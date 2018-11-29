package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Guest;


public class GuestShowDAO {
	private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/inn";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";
	public List<Guest> showAll(){

		Connection conn = null;
		List<Guest> guestList = new ArrayList<>();
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			//select文の準備
			String sql = "SELECT guest_id ,guest_name, guest_kana from guest_t order by guest_kana desc";
			java.sql.PreparedStatement pStmt = conn.prepareStatement(sql);
			//selectを実行し結果表(ResultSet)を取得
			ResultSet rs = pStmt.executeQuery();

			//結果表に格納されたレコードの内容を表示
			while (rs.next()) {
				int id = rs.getInt("guest_id");
				String name = rs.getString("guest_name");
				String kana = rs.getString("guest_kana");

				Guest guest = new Guest(id, name, kana);
				guestList.add(guest);
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
		return guestList;
	}
		//TODO 他のメソッドも実装
}
