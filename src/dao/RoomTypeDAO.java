package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.RoomType;

public class RoomTypeDAO {
	private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/inn";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	public List<RoomType> showAll(){
		Connection conn = null;
		List<RoomType> roomTypeList = new ArrayList<>();
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql = "SELECT room_type_id,room_type_name,adult_capacity,child_capacity,adult_charge,child_charge"
					+ " FROM room_type_t";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			//結果表に格納されたレコードの内容を表示
			while (rs.next()) {
				int roomTypeId = rs.getInt(1);
				String roomTypeName = rs.getString(2);
				int adultCapacity = rs.getInt(3);
				int childCapacity = rs.getInt(4);
				int adultCharge = rs.getInt(5);
				int childCharge = rs.getInt(6);

				RoomType room = new RoomType(roomTypeId, roomTypeName, adultCapacity, childCapacity, adultCharge, childCharge);
				roomTypeList.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			//データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return roomTypeList;
	}

	public boolean update(RoomType roomType) {
		Connection conn = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql ="UPDATE room_type_t"
					+ " SET room_type_name=?"
					+ " ,adult_capacity=?,child_capacity=?,adult_charge=?,child_charge=?"
					+ " WHERE room_type_id=?";

			PreparedStatement pSmt = conn.prepareStatement(sql);
			pSmt.setString(1, roomType.getRoomTypeName());
			pSmt.setInt(2, roomType.getAdultCapacity());
			pSmt.setInt(3, roomType.getChildCapacity());
			pSmt.setInt(4, roomType.getAdultCharge());
			pSmt.setInt(5, roomType.getChildCharge());
			pSmt.setInt(6, roomType.getRoomTypeId());

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

	public boolean insert(RoomType roomType) {
		Connection conn = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql ="insert into room_type_t"
					+ " (room_type_name,adult_capacity,child_capacity,adult_charge,child_charge)"
					+ " VALUES (?,?,?,?,?)";

			PreparedStatement pSmt = conn.prepareStatement(sql);
			pSmt.setString(1, roomType.getRoomTypeName());
			pSmt.setInt(2, roomType.getAdultCapacity());
			pSmt.setInt(3, roomType.getChildCapacity());
			pSmt.setInt(4, roomType.getAdultCharge());
			pSmt.setInt(5, roomType.getChildCharge());

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
