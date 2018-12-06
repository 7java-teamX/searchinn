package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Reserve;

public class ReserveInsertDAO {
	public boolean insert(Reserve reserve) {
		Connection conn = null;
		String DRIVER_NAME ="com.mysql.jdbc.Driver" ;
		String JDBC_URL = "jdbc:mysql://localhost:3306/inn";
		String DB_user = "root";
		String DR_pass = "root";

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL,DB_user,DR_pass);


			String sql ="INSERT INTO reserve_t"
					+ " (guest_id,plan_id,num_of_adults,num_of_children,checkin,num_of_nights,reserve_date,charge,reserve_memo)"
					+ " VALUES"
					+ " (?,?,?,?,?,?,?,?,?)";

			PreparedStatement pSmt = conn.prepareStatement(sql);
			pSmt.setInt(1, reserve.getGuestId());
			pSmt.setInt(2, reserve.getPlanId());
			pSmt.setInt(3, reserve.getNumOfAdults());
			pSmt.setInt(4, reserve.getNumOfChildren());
			pSmt.setString(5, reserve.getCheckin());
			pSmt.setInt(6, reserve.getNumOfNights());
			pSmt.setString(7, reserve.getReserveDate());
			pSmt.setInt(8, reserve.getCharge());
			pSmt.setString(9, reserve.getReserveMemo());

			int result = pSmt.executeUpdate();
			if(result != 1) {
				return false;
			}
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
