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
			String searchName = criteria.getName();
			String searchKana = criteria.getKana();
			String searchTel = criteria.getTel();
			String searchMail = criteria.getMail();
			String whereOrAnd = " WHERE";
			System.out.println("searchId: " + seachId);
			System.out.println("searchName: " + searchName);
			System.out.println("searchKana: " + searchKana);
			System.out.println("searchTel: " + searchTel);
			System.out.println("searchMail: " + searchMail);

			try {
				Class.forName(DRIVER_NAME);
				conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
				//select文の準備
				String sql = "SELECT guest_id ,guest_name, guest_tel,guest_mail, guest_kana FROM guest_t ";


				PreparedStatement pStmt = conn.prepareStatement(sql);

				//条件に応じてSQL文を追加
				if(seachId != -1) {
					sql += whereOrAnd +" guest_id = ? ";

					whereOrAnd =" AND ";
					System.out.println("refineSearchSql id");
				}
				if(searchName != null && searchName != "") {
					sql += whereOrAnd +" guest_name LIKE ?";

					whereOrAnd =" AND ";
					System.out.println("refineSearchSql name");
				}
				if(searchKana != null && searchKana != "") {
					sql += whereOrAnd +" guest_kana LIKE ? ";

					whereOrAnd =" AND ";
					System.out.println("refineSearchSql kana");
				}
				if(searchTel != null && searchTel != "") {
					sql += whereOrAnd +" guest_tel =? ";

					whereOrAnd =" AND ";
					System.out.println("refineSearchSql tel");
				}
				if(searchMail != null && searchMail != "") {
					sql += whereOrAnd +" guest_mail =? ";

					System.out.println("refineSearchSql mail" );
				}
				sql += ";";
				pStmt = conn.prepareStatement(sql);
				int columnIndex = 1;
				if(seachId != -1) {
					pStmt.setString(columnIndex, "" + seachId);
					columnIndex++;
				}
				if(searchName != null && searchName != "") {
					pStmt.setString(columnIndex, "%" + searchName + "%");
					columnIndex++;
				}
				if(searchKana != null && searchKana != "") {
					pStmt.setString(columnIndex, "%" + searchKana + "%");
					columnIndex++;
				}
				if(searchTel != null && searchTel != "") {
					pStmt.setString(columnIndex, searchTel);
					columnIndex++;
				}
				if(searchMail != null && searchMail != "") {
					pStmt.setString(columnIndex, searchMail);
				}
				System.out.println(sql);
				//selectを実行し結果表(ResultSet)を取得
				ResultSet rs = pStmt.executeQuery();

				//結果表に格納されたレコードの内容を表示
				while (rs.next()) {
					System.out.println("while");
					int id = rs.getInt("guest_id");
					String name = rs.getString("guest_name");
					String kana = rs.getString("guest_kana");
					String tel = rs.getString("guest_tel");
					String mail = rs.getString("guest_mail");

					Guest guest = new Guest(id, name,kana, tel,mail);
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
				String tel = rs.getString("guest_tel");
				String address = rs.getString("guest_address");
				String mail = rs.getString("guest_mail");

				guest = new Guest(id, name, kana,birthday,tel,mail,address);
				System.out.println(guestId + name +kana+  birthday+ tel+ mail+ address);
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
