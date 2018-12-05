
package dao;

import java.sql.Connection;  //接続や切断
import java.sql.DriverManager;//接続準備
import java.sql.PreparedStatement; //SQLの送信を行う
import java.sql.ResultSet; //DBMSから検索結果を受け取る
import java.sql.SQLException; //DB関連のエラー
import java.util.ArrayList; //
import java.util.List; //

import model.Reserve;


public class GReserveShowDAO {
	// データベース接続のためにString型で変数宣言
	private final String DriverName = "com.mysql.jdbc.Driver";
	private final String JDBCURL = "jdbc:mysql://localhost:3306/inn"; //接続先データベース
	private final String DBUser = "root"; // user名
	private final String DBPass = "root"; // pass名
	//private final String DBPass = "Reina9110Nao"; // pass名自宅用

	////ゲストidを元に予約情報をarrayListで抽出するメソッド(つぶやきの内容取得)
	public List<Reserve> selectReserve(int guestId) {
		Connection conn = null;

		//検索条件を呼び出し
		List<Reserve> reserveList = new ArrayList<Reserve>();

		try {
			Class.forName(DriverName);
			conn = DriverManager.getConnection(JDBCURL, DBUser, DBPass);

			//sql文で検索条件を設定させる
			String sql = "select "+
				"r.reserve_id,r.num_of_adults,r.num_of_children,r.checkin,"+
				"r.num_of_nights,r.reserve_date,r.charge,r.reserve_memo,"+
				"p.plan_name,p.plan_image,p.plan_detail,"+
				"h.hotel_name,h.hotel_address,h.hotel_tel,"+
				"h.hotel_mail,h.hotel_image,h.hotel_detail,"+
				"t.room_type_name,t.adult_capacity,t.child_capacity,"+
				"t.adult_charge,t.child_charge "+
				"from reserve_t as r "+
				"join plan_t as p "+
				"on r.plan_id = p.plan_id "+
				"join hotel_t as h "+
				"on p.hotel_id = h.hotel_id "+
				"join room_type_t as t "+
				"on t.room_type_id = p.room_type_id "+
				"where guest_id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, guestId);

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				 int reserveId = rs.getInt("reserve_id");
				 int numOfAdults = rs.getInt("num_of_adults");
				 int numOfChildren = rs.getInt("num_of_children");
				 String checkin = rs.getString("checkin");
				 int numOfNights = rs.getInt("num_of_nights"); //泊数
				 String reserveDate = rs.getString("reserve_date");
				 int charge= rs.getInt("charge");

				 String reserveMemo = rs.getString("reserve_memo");
				 String planName = rs.getString("plan_name");
				 String planImage = rs.getString("plan_image");
				 String planDetail = rs.getString("plan_detail");

				 String hotelName = rs.getString("hotel_name");
				 String hotelAddress = rs.getString("hotel_address");
				 String hotelTel = rs.getString("hotel_tel");
				 String hotelMail = rs.getString("hotel_mail");
				 String hotelImage = rs.getString("hotel_image");
				 String hotelDetail = rs.getString("hotel_detail");

				 int adultCapacity = rs.getInt("adult_capacity");
				 int childCapacity = rs.getInt("child_capacity");
				 int adultCharge = rs.getInt("adult_charge");
				 int childCharge = rs.getInt("child_charge");

				Reserve reserveInfo = new Reserve(
						reserveId,numOfAdults,numOfChildren,checkin,	numOfNights,reserveDate,  charge,reserveMemo,
						planName,planImage,planDetail,
						hotelName,hotelAddress,hotelTel, hotelMail, hotelImage,
						hotelDetail,adultCapacity,childCapacity,adultCharge,childCharge);
				reserveList.add(reserveInfo);
			}
		} //try FIN
		catch(SQLException se) { //接続,SQL処理失敗時
			se.printStackTrace();
		} // catch FIN
		catch(ClassNotFoundException ce) { //JDBCドライバが見つからないとき
			ce.printStackTrace();
		} // catch FIN
		finally{
			//データベース切断
			if(conn != null) {
				try {
					conn.close();
				} //try FIN
				catch(SQLException se) {
					se.printStackTrace();
				}    //catch FIN
			} // if FIN
		}     // finally FIN
		//結果を返す
		return reserveList;
	} //findAll()メソッド FIN



	//予約変更を行うメソッド()
		public void updateReserve(Reserve reserveInfo) {
			Connection conn = null;
			//変更内容の呼び出し
			int reserveId = reserveInfo.getReserveId();
			int numOfAdults = reserveInfo.getNumOfAdults();
			int numOfChildren = reserveInfo.getNumOfChildren();
			int charge = reserveInfo.getCharge();
			String reserveMemo = reserveInfo.getReserveMemo();

			try {
				Class.forName(DriverName);
				conn = DriverManager.getConnection(JDBCURL, DBUser, DBPass);

				//sql文で変更内容の設定
				String sql = "update reserve_t "+
					"set num_of_children = ?, num_of_adults = ?, charge = ? ,reserve_memo = ?"+
					"where reserve_id = ? ";

				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, numOfChildren);
				pStmt.setInt(2, numOfAdults);
				pStmt.setInt(3, charge);
				pStmt.setString(4, reserveMemo);
				pStmt.setInt(5, reserveId);

				//System.out.println(sql);
				pStmt.executeUpdate(); //updateの実行

			} //try FIN
			catch(SQLException se) { //接続,SQL処理失敗時
				se.printStackTrace();
			} // catch FIN
			catch(ClassNotFoundException ce) { //JDBCドライバが見つからないとき
				ce.printStackTrace();
			} // catch FIN
			finally{
				//データベース切断
				if(conn != null) {
					try {
						conn.close();
					} //try FIN
					catch(SQLException se) {
						se.printStackTrace();
					}    //catch FIN
				} // if FIN
			}     // finally FIN
		} //updateReserve()メソッド FIN


		//予約レコード削除メソッド
		public void deleteReserve(int reserveId) {
			Connection conn = null;
			//int reserveId = reserveInfo.getReserveId(); //削除対象レコードの予約ID
			try {
				Class.forName(DriverName);
				conn = DriverManager.getConnection(JDBCURL, DBUser, DBPass);
				String sql = "delete from reserve_t where reserve_id = ? ;";

				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, reserveId);
				//System.out.println(sql);

				pStmt.executeUpdate();//deleteの実行
			} //try FIN
			catch(SQLException se) { //接続,SQL処理失敗時
				se.printStackTrace();
			} // catch FIN
			catch(ClassNotFoundException ce) { //JDBCドライバが見つからないとき
				ce.printStackTrace();
			} // catch FIN
			finally{
				//データベース切断
				if(conn != null) {
					try {
						conn.close();
					} //try FIN
					catch(SQLException se) {
						se.printStackTrace();
					}    //catch FIN
				} // if FIN
			}     // finally FIN
		} //findAll()メソッド FIN
}