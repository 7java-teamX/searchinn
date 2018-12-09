package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Hotel;

public class HotelDAO {
	private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/inn";
	private final String DB_USER = "root";
	//private final String DB_PASS = "root";
	private final String DB_PASS = "Reina9110Nao";
	public List<Hotel> showAll(){
		Connection conn = null;
		List<Hotel> hotelList = new ArrayList<>();
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql ="SELECT area_id,hotel_id,hotel_name,hotel_address,hotel_tel,hotel_mail,hotel_image,hotel_detail"
					+ "	FROM hotel_t";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			//結果表に格納されたレコードの内容を表示
			while (rs.next()) {
				int areaId = rs.getInt(1);
				int hotelId = rs.getInt(2);
				String hotelName = rs.getString(3);
				String hotelAddress = rs.getString(4);
				String hotelTel = rs.getString(5);
				String hotelMail = rs.getString(6);
				String hotelImage = rs.getString(7);
				String hotelDetail = rs.getString(8);

				Hotel hotel = new Hotel(areaId, hotelId, hotelName, hotelAddress, hotelTel, hotelMail, hotelImage, hotelDetail);
				hotelList.add(hotel);
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
		return hotelList;
	}
}
