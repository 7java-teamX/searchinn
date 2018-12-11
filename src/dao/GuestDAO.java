package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Guest;

public class GuestDAO {
	// ドライバーの設定
	private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/inn";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	//会員登録時insert → guest_t
	public boolean registerInsert(Guest guest) {

		Connection conn = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			//select文の準備
			String sql = "INSERT INTO guest_t"
					+ "(guest_name,guest_kana,guest_pass,guest_birthday,guest_tel,guest_mail,guest_address) "
					+ "VALUES(?,?,?,?,?,?,?)";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			//INSERT文のVALUESに入る値の設定
			pStmt.setString(1, guest.getName());
			pStmt.setString(2, guest.getKana());
			pStmt.setString(3, guest.getPass());
			pStmt.setString(4, guest.getBirthday());
			pStmt.setString(5, guest.getTel());
			pStmt.setString(6, guest.getMail());
			pStmt.setString(7, guest.getAddress());

			//INSERT文を実行
			int result = pStmt.executeUpdate();

			if (result == 1) {
				return true;
			} //if

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
		return false;
	}


	//会員登録時にメールアドレスの重複が存在するかを確認 select → guest_t
	public boolean registerCheck(Guest guest) {
		Connection conn = null;
		boolean isExist = true;
		String guestIdStr = String.valueOf(guest.getGuestId());

		if(guestIdStr != null && "".equals(guestIdStr)) {
			guestIdStr = "-1";
		}
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			//select文の準備
			String sql = "SELECT guest_mail "
					+ "from guest_t "
					+ "WHERE guest_mail = ?  "
					+ "AND guest_id != ?;";
			java.sql.PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, guest.getMail());
			pStmt.setString(2, guestIdStr);
			//selectを実行し結果表(ResultSet)を取得
			ResultSet rs = pStmt.executeQuery();

			//結果表に格納されたレコードの内容を表示
			if (rs.next()) {
				isExist = false;
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
		return isExist;
	}



	//顧客ログイン時対象のレコードが存在するかを確認するメソッド
	//select → guest_t
	public boolean selectLogin(Guest guest){
		Connection conn = null;
		String strmail = guest.getMail();
		String strpass = guest.getPass();
		boolean isExist = false;

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			//select文の準備
			String sql = "SELECT guest_mail guest_pass "
					+ "from guest_t "
					+ "where guest_mail = ? and guest_pass = ?";
			java.sql.PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, strmail);
			pStmt.setString(2, strpass);

			//selectを実行し結果表(ResultSet)を取得
			ResultSet rs = pStmt.executeQuery();

			//結果表に格納されたレコードの内容を表示
			if (rs.next()) {
				isExist = true;
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
		return isExist;
	}


	//ログイン時に対象のレコードが存在するかを確認 select → guest_t
		public Guest Allselect(Guest guest) {
			Connection conn = null;

			try {
				Class.forName(DRIVER_NAME);
				conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
				//select文の準備
				String sql = "SELECT guest_id,guest_name,guest_kana,guest_pass,"
						+ "guest_birthday,guest_tel,guest_mail,guest_address"
						+ " from guest_t "
						+ "where guest_mail = ?";
				java.sql.PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, guest.getMail());

				//selectを実行し結果表(ResultSet)を取得
				ResultSet rs = pStmt.executeQuery();

				//結果表に格納されたレコードの内容を表示
				if (rs.next()) {
					int guestId = rs.getInt("guest_id");
					String name = rs.getString("guest_name");
					String kana = rs.getString("guest_kana");
					String birthday = rs.getString("guest_birthday");
					String tel = rs.getString("guest_tel");
					String mail = rs.getString("guest_mail");
					String address = rs.getString("guest_address");
					guest = new Guest(guestId, name, kana, birthday, tel, mail, address);

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


