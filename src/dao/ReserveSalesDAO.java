package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.SalesInfo;

public class ReserveSalesDAO {
	public List<SalesInfo> hotelSales(String term) {
		System.out.println("DAO開始");
		System.out.println(term);

		Connection conn = null;
		String DRIVER_NAME ="com.mysql.jdbc.Driver" ;
		String JDBC_URL = "jdbc:mysql://localhost:3306/inn";
		String DB_user = "root";
		String DR_pass = "root";


		List<SalesInfo> salesInfoList = new ArrayList<>();
		SalesInfo salesInfo = null;

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL,DB_user,DR_pass);

			String sql ="SELECT area_t.area_id,area_t.area_name,hotel_t.hotel_id,hotel_t.hotel_name,SUM(charge) "
					+ " FROM reserve_t"
					+ " JOIN plan_t"
					+ " ON reserve_t.plan_id=plan_t.plan_id"
					+ " JOIN hotel_t"
					+ " ON plan_t.hotel_id=hotel_t.hotel_id"
					+ " JOIN area_t"
					+ " ON hotel_t.area_id=area_t.area_id"
					+ " WHERE checkin LIKE ?"
					+ " GROUP BY hotel_t.hotel_id"
					+ " ORDER BY area_t.area_id asc,hotel_t.hotel_id asc";

			PreparedStatement pSmt = conn.prepareStatement(sql);
			pSmt.setString(1, term + "%");
			ResultSet rs = pSmt.executeQuery();

			//SELECT文の結果を配列に格納
			while(rs.next()) {
				int areaId = rs.getInt("area_t.area_id");
				String areaName = rs.getString("area_t.area_name");
				int hotelId = rs.getInt("hotel_t.hotel_id");
				String hotelName = rs.getString("hotel_t.hotel_name");
				int sales = rs.getInt("SUM(charge)");

				salesInfo = new SalesInfo(areaId, areaName, hotelId, hotelName, sales);
				salesInfoList.add(salesInfo);
			}// while
		}//try
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		catch(SQLException se) {
			se.printStackTrace();
			return null;
		}
		finally {
			if(conn != null) {
				try {
					conn.close(); //DBMSの JDBC リソースを解除
				}
				catch(SQLException se) {
					se.printStackTrace();
					return null;
				}
			}
		} //finally
		return salesInfoList;
	} // hotelSales(String term) fin

	public List<SalesInfo> areaSales(String term) {
		Connection conn = null;
		String DRIVER_NAME ="com.mysql.jdbc.Driver" ;
		String JDBC_URL = "jdbc:mysql://localhost:3306/inn";
		String DB_user = "root";
		String DR_pass = "root";

		List<SalesInfo> salesInfoList = new ArrayList<>();
		SalesInfo salesInfo = null;

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL,DB_user,DR_pass);

			String sql ="SELECT area_t.area_id,area_t.area_name,SUM(charge)"
					+ " FROM reserve_t"
					+ " JOIN plan_t"
					+ " ON reserve_t.plan_id=plan_t.plan_id"
					+ " JOIN hotel_t"
					+ " ON plan_t.hotel_id=hotel_t.hotel_id"
					+ " JOIN area_t"
					+ " ON hotel_t.area_id=area_t.area_id"
					+ " WHERE checkin LIKE ?"
					+ " GROUP BY area_t.area_id"
					+ " ORDER BY area_t.area_id asc";

			PreparedStatement pSmt = conn.prepareStatement(sql);
			pSmt.setString(1, term + "%");
			ResultSet rs = pSmt.executeQuery();

			//SELECT文の結果を配列に格納
			while(rs.next()) {
				int areaId = rs.getInt("area_t.area_id");
				String areaName = rs.getString("area_t.area_name");
				int sales = rs.getInt("SUM(charge)");

				salesInfo = new SalesInfo(areaId, areaName, sales);
				salesInfoList.add(salesInfo);
			}// while
		}//try
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		catch(SQLException se) {
			se.printStackTrace();
			return null;
		}
		finally {
			if(conn != null) {
				try {
					conn.close(); //DBMSの JDBC リソースを解除
				}
				catch(SQLException se) {
					se.printStackTrace();
					return null;
				}
			}
		} //finally
//
		for (int i = 0; i < salesInfoList.size(); i++) {
			System.out.println("l136" + salesInfoList.get(i));
		}

		return salesInfoList;
	} // areaSales(String term) fin

	public List<SalesInfo> totalSales(String term) {
		Connection conn = null;
		String DRIVER_NAME ="com.mysql.jdbc.Driver" ;
		String JDBC_URL = "jdbc:mysql://localhost:3306/inn";
		String DB_user = "root";
		String DR_pass = "root";

		List<SalesInfo> salesInfoList = new ArrayList<>();
		SalesInfo salesInfo = null;

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL,DB_user,DR_pass);

			String sql ="SELECT SUM(charge)"
					+ " FROM reserve_t"
					+ " WHERE checkin LIKE ?";

			PreparedStatement pSmt = conn.prepareStatement(sql);
			pSmt.setString(1, term + "%");
			ResultSet rs = pSmt.executeQuery();

			//SELECT文の結果を配列に格納
			if(rs.next()) {
				int sales = rs.getInt("SUM(charge)");
				salesInfo = new SalesInfo(sales);
				salesInfoList.add(salesInfo);
			}// while
		}//try
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		catch(SQLException se) {
			se.printStackTrace();
			return null;
		}
		finally {
			if(conn != null) {
				try {
					conn.close(); //DBMSの JDBC リソースを解除
				}
				catch(SQLException se) {
					se.printStackTrace();
					return null;
				}
			}
		} //finally
		return salesInfoList;
	} // totalSales(String term) fin

}
