package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReserveInsertDAO {
	public boolean insert(Reserve reserve) {
		Connection conn = null;
		String DRIVER_NAME ="com.mysql.jdbc.Driver" ;
		String JDBC_URL = "jdbc:mysql://localhost:3306/inn";
		String DB_user = "root";
		String DR_pass = "root";

//		int reserveMax[] = new int[31];
//		int reserveCount[] = new int[31];  //最大31日まで部屋の予約数を配列で格納
//		int roomAvailable[] = new int[31];
//		String firstDay = ym + "-01";    	//当月の月初の日付をString型で格納
//		int numDays = countDays(firstDay);;  					//当月の月末の日付をint型で格納

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL,DB_user,DR_pass);


			String sql ="INSERT INTO reserve_t"
					+ " (guest_id,plan_id,num_of_adults,num_of_children,checkin,num_of_nights,reserve_date,charge,reserve_memo)"
					+ " VALUES"
					+ " (?,?,?,?,?,?,?,?,?)";

			PreparedStatement pSmt = conn.prepareStatement(sql);
			pSmt.setInt(1, plan.);
			pSmt.setInt(2, plan.);
			pSmt.setInt(3, plan.);
			pSmt.setInt(4, plan.);
			pSmt.setString(5, plan.);
			pSmt.setInt(6, plan.);
			pSmt.setString(7, plan.);
			pSmt.setString(8, plan.);
			pSmt.setInt(9, plan.);
			pSmt.setString(10, plan.);

			int result = pSmt.executeUpdate();
		}//try
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		catch(SQLException se) {
			se.printStackTrace();
			return false;
		}
		finally {
			if(conn != null) {
				try {
					conn.close(); //DBMSの JDBC リソースを解除
				}
				catch(SQLException se) {
					se.printStackTrace();
					return false;
				}
			}
		} //finally
		return true;
	} // countReserveDate() fin

}
