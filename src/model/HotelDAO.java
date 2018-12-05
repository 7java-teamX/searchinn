package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {
	private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/inn";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	public List<Hotel> showAll(){
		Connection conn = null;
		List<Hotel> hotelList = new ArrayList<>();
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql ="SELECT hotel_id,area_id,hotel_name,hotel_address,hotel_tel,hotel_mail,hotel_image,hotel_detail"
					+ "	FROM hotel_t";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			//結果表に格納されたレコードの内容を表示
			while (rs.next()) {
				int hotelId = rs.getInt(1);
				String hotelName = rs.getString(2);
				String hotelAddress = rs.getString(3);
				String hotelTel = rs.getString(4);
				String hotelMail = rs.getString(5);
				String hotelImage = rs.getString(6);
				String hotelDetail = rs.getString(7);

				Hotel hotel = new Hotel(hotelId, hotelName, hotelAddress, hotelTel, hotelMail, hotelImage, hotelDetail);
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
