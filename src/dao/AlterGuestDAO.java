package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Guest;

public class AlterGuestDAO {

	private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/inn";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	/**
	 * ログイン画面で入力した管理者名とpassがあっているか確かめる
	 * @param admin
	 * @return
	 */
	public void delete(int id) {
		String guestId = "" + id;
		Connection conn = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			//select文の準備
			String sql = "DELETE FROM guest_t" +
						" WHERE guest_id = ?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, guestId);
			//selectを実行し結果表(ResultSet)を取得
			pStmt.executeUpdate();

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

	}

	public void update(Guest guest) {

		Connection conn = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			//UPDATE文の準備
			String sql = "UPDATE guest_t " +
						"SET guest_name=?,guest_kana=?,guest_tel=?,guest_mail=?,guest_address=?" +
						" WHERE guest_id =?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, guest.getName());
			pStmt.setString(2, guest.getKana());
			pStmt.setString(3, guest.getTel());
			pStmt.setString(4, guest.getMail());
			pStmt.setString(5, guest.getAddress());
			pStmt.setString(6, "" + guest.getGuestId());
			//UPDATEを実行し
			 pStmt.executeUpdate();

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

	}
}
