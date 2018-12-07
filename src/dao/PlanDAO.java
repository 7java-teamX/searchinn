
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Plan;

public class PlanDAO {
	private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/inn";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";
	//private final String DB_PASS = "Reina9110Nao";
	/**
	 * ホテル選択後のプラン一覧表示に使用
	 * @param hotelId
	 * @return
	 */
	public List<Plan> selectByHotelId(int hotelId){
		Connection conn = null;
		List<Plan> planList = new ArrayList<>();
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql = "SELECT plan_id,plan_name,num_of_rooms,plan_image,plan_detail,plan_t.room_type_id,room_type_name,adult_capacity,child_capacity,adult_charge,child_charge,plan_t.hotel_id,hotel_name,hotel_address,hotel_tel,hotel_mail,hotel_image,hotel_detail"
			+ " FROM plan_t"
			+ " JOIN room_type_t"
			+ " ON plan_t.room_type_id=room_type_t.room_type_id"
			+ " JOIN hotel_t"
			+ " ON plan_t.hotel_id=hotel_t.hotel_id"
			+ " WHERE plan_t.hotel_id=?;";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, hotelId);
			ResultSet rs = pStmt.executeQuery();

			//結果表に格納されたレコードの内容を表示
			while (rs.next()) {
				int planId = rs.getInt(1);
				String planName = rs.getString(2);
				int numRoom = rs.getInt(3);
				String planImage = rs.getString(4);
				String planDetail = rs.getString(5);
				int roomTypeId = rs.getInt(6);
				String roomTypeName = rs.getString(7);
				int adultCapacity = rs.getInt(8);
				int childCapacity = rs.getInt(9);
				int adultCharge = rs.getInt(10);
				int childCharge = rs.getInt(11);
				hotelId = rs.getInt(12);
				String hotelName = rs.getString(13);
				String hotelAddress = rs.getString(14);
				String hotelTel = rs.getString(15);
				String hotelmail = rs.getString(16);
				String hotelImage = rs.getString(17);
				String hotelDetail = rs.getString(18);
				Plan plan = new Plan(planId, planName, numRoom, planImage, planDetail, roomTypeId, roomTypeName, adultCapacity, childCapacity, adultCharge, childCharge, hotelId, hotelName, hotelAddress, hotelTel, hotelmail, hotelImage, hotelDetail);
				planList.add(plan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			//データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return planList;
	}

	public List<Plan> showAll(){
		Connection conn = null;
		List<Plan> planList = new ArrayList<>();
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql = "SELECT plan_id,plan_name,hotel_id,room_type_id,num_of_rooms,plan_image,plan_detail"
			+ " FROM plan_t";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			//結果表に格納されたレコードの内容を表示
			while (rs.next()) {
				int planId = rs.getInt(1);
				String planName = rs.getString(2);
				int hotelId = rs.getInt(3);
				int roomTypeId = rs.getInt(4);
				int numRoom = rs.getInt(5);
				String planImage = rs.getString(6);
				String planDetail = rs.getString(7);

				Plan plan = new Plan(planId, planName, hotelId, roomTypeId, numRoom, planImage, planDetail);
				planList.add(plan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			//データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return planList;
	}

	public boolean update(Plan plan) {
		Connection conn = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql ="UPDATE plan_t"
					+ " SET plan_name=?,hotel_id=?,room_type_id=?"
					+ " ,num_of_rooms=?,plan_image=?,plan_detail=?"
					+ " WHERE plan_id=?";

			PreparedStatement pSmt = conn.prepareStatement(sql);
			pSmt.setString(1, plan.getPlanName());
			pSmt.setInt(2, plan.getHotelId());
			pSmt.setInt(3, plan.getRoomTypeId());
			pSmt.setInt(4, plan.getNumRoom());
			pSmt.setString(5, plan.getPlanImage());
			pSmt.setString(6, plan.getPlanDetail());
			pSmt.setInt(7, plan.getPlanId());

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
