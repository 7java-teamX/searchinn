package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Admin;


/**
 * @author 3BC1_12
 *
 */
public class AdminDAO {
	private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/inn";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";
	/**
	 * ログイン画面で入力した管理者名とpassがあっているか確かめる
	 * @param admin
	 * @return
	 */
	public boolean findByLogin(Admin admin){
		Connection conn = null;
		boolean isExist = false;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			//select文の準備
			String sql = "SELECT admin_id , admin_pass FROM admin_t " +
						  "WHERE admin_id = ? AND admin_pass = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, admin.getId());
			pStmt.setString(2, admin.getPass());
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
}
