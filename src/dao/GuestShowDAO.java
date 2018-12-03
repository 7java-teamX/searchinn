package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Guest;


/**
 * @author 3BC1_12
 *
 */
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
			String sql = "SELECT guest_id ,guest_name, guest_kana,guest_tel,guest_mail FROM guest_t ORDER BY guest_kana ASC";
			java.sql.PreparedStatement pStmt = conn.prepareStatement(sql);
			//selectを実行し結果表(ResultSet)を取得
			ResultSet rs = pStmt.executeQuery();

			//結果表に格納されたレコードの内容を表示
			while (rs.next()) {
				int id = rs.getInt("guest_id");
				String name = rs.getString("guest_name");
				String kana = rs.getString("guest_kana");
				String tel = rs.getString("guest_tel");
				String mail = rs.getString("guest_mail");
				Guest guest = new Guest(id, name, kana,tel,mail);
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
	/*
	 * 顧客情報絞り込み検索機能
	 */
		public List<Guest> refineSearch(Guest criteria){
			Connection conn = null;
			List<Guest> guestList = new ArrayList<>();
			int seachId = criteria.getGuestId();
			String seachIdName = criteria.getName();
			String seachTel = criteria.getTel();
			String seachMail = criteria.getMail();
			String whereOrAnd = " WHERE";
			try {
				Class.forName(DRIVER_NAME);
				conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
				//select文の準備
				String sql = "SELECT guest_id ,guest_name, guest_tel,guest_mail, guest_kana FROM guest_t AS g ";


				PreparedStatement pStmt = conn.prepareStatement(sql);
				//条件に応じてSQL文を追加
				if(seachId != -1) {
					sql += whereOrAnd +" g.guest_id = " + seachId;
					whereOrAnd =" AND";
				}
				if(seachIdName != null && seachIdName == "") {
					sql += whereOrAnd +" g.guest_name = " + seachIdName;
					whereOrAnd =" AND";
				}
				if(seachTel != null && seachTel == "") {
					sql += whereOrAnd +" g.guest_tel = " + seachTel;
					whereOrAnd =" AND";
				}
				if(seachMail != null && seachMail == "") {
					sql += whereOrAnd +" g.seachIdName = " + seachMail;
				}
				sql += ";";
				//selectを実行し結果表(ResultSet)を取得
				ResultSet rs = pStmt.executeQuery();

				//結果表に格納されたレコードの内容を表示
				while (rs.next()) {
					int id = rs.getInt("guest_id");
					String name = rs.getString("guest_name");
					String tel = rs.getString("guest_tel");
					String mail = rs.getString("guest_mail");

					Guest guest = new Guest(id, name, tel,mail);
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
	public Guest detailSearch(int id) {
		Connection conn = null;
		Guest guest = null;
		String guestId = Integer.toString(id);
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			//select文の準備
			String sql = "SELECT guest_name, guest_kana,guest_birthday,guest_tel, guest_mail,guest_address FROM guest_t "+
						"WHERE guest_id = ?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, guestId);
			//selectを実行し結果表(ResultSet)を取得
			ResultSet rs = pStmt.executeQuery();

			//結果表に格納されたレコードの内容を表示
			if (rs.next()) {
				String name = rs.getString("guest_name");
				String kana = rs.getString("guest_kana");
				String birthday = rs.getString("guest_birthday");
				String tel = rs.getString("guest_mail");
				String address = rs.getString("guest_address");
				String mail = rs.getString("guest_mail");

				guest = new Guest(id, name, kana,birthday,tel,address,mail);
				System.out.println(guestId + name +kana+  birthday+ tel+ address+ mail);
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
		return guest;
	}
}
