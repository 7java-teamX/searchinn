
package dao;

import java.sql.Connection;  //接続や切断
import java.sql.DriverManager;//接続準備
import java.sql.PreparedStatement; //SQLの送信を行う
import java.sql.ResultSet; //DBMSから検索結果を受け取る
import java.sql.SQLException; //DB関連のエラー
import java.util.ArrayList; //
import java.util.List; //

import model.Reserve;

//検索条件を元に予約情報をarrayListで抽出させる

public class ReserveShowDAO {
	// データベース接続のためにString型で変数宣言
	private final String DriverName = "com.mysql.jdbc.Driver";
	private final String JDBCURL = "jdbc:mysql://localhost:3306/inn"; //接続先データベース
	private final String DBUser = "root"; // user名
	private final String DBPass = "root"; // pass名
	//private final String DBPass = "Reina9110Nao"; // pass名


	//検索条件で取得するメソッド(つぶやきの内容取得)
	public List<Reserve> selectReserve(Reserve refineSearch) {
		Connection conn = null;

		//検索条件を呼び出し
		String day = refineSearch.getDay();
		String hotelName = refineSearch.getHotelName();
		String planName = refineSearch.getPlanName();
		String guestName = refineSearch.getGuestName();
		List<Reserve> reserveList = new ArrayList<Reserve>();
		String whereOrAnd = " where ";

		try {
			Class.forName(DriverName);
			conn = DriverManager.getConnection(JDBCURL, DBUser, DBPass);

			//sql文で検索条件を設定させる
			String sql = "select "+
				"g.guest_id,g.guest_name,g.guest_kana,g.guest_birthday,"+
				"g.guest_tel,g.guest_mail,g.guest_address,"+
				"r.reserve_id,r.num_of_adults,r.num_of_children,r.checkin,"+
				"r.num_of_nights,r.reserve_date,r.charge,r.reserve_memo,"+
				"p.plan_name,p.plan_image,p.plan_detail,"+
				"h.hotel_name,h.hotel_address,h.hotel_tel,"+
				"h.hotel_mail,h.hotel_image,h.hotel_detail,"+
				"t.room_type_name,t.adult_capacity,t.child_capacity,"+
				"t.adult_charge,t.child_charge "+
				"from reserve_t as r "+
				"join guest_t as g "+
				"on r.guest_id = g.guest_id "+
				"join plan_t as p "+
				"on r.plan_id = p.plan_id "+
				"join hotel_t as h "+
				"on p.hotel_id = h.hotel_id "+
				"join room_type_t as t "+
				"on t.room_type_id = p.room_type_id ";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			if(day != null && day != "") {
				sql  += whereOrAnd + "reserve_date like ?";
				whereOrAnd =" AND ";
			}
			if(hotelName != null && hotelName != "") {
				sql  += whereOrAnd + "hotel_name like ? ";
				whereOrAnd =" AND ";
			}
			if(planName != null && planName != "") {
				sql  += whereOrAnd + "plan_name like ? ";
				whereOrAnd =" AND ";
			}
			if(guestName != null && guestName != "") {
				sql  += whereOrAnd + "guest_name like ? ";
				whereOrAnd =" AND";
			}

			pStmt = conn.prepareStatement(sql);
			int i = 1;

			if(day != null && day != "") {
				pStmt.setString(i, "%"+ day +"%");
				i++;
			}
			if(hotelName != null && hotelName != "") {
				pStmt.setString(i, "%" + hotelName + "%");
				i++;
			}
			if(planName != null && planName != "") {
				pStmt.setString(i, "%" + planName + "%");
				i++;
			}
			if(guestName != null && guestName != "") {
				pStmt.setString(i, "%" + guestName + "%");
				i++;
			}

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				 String guestId = rs.getString("guest_id");
				 guestName = rs.getString("guest_name");
				 String guestKana = rs.getString("guest_kana");
				 String guestBirthday  = rs.getString("guest_birthday");
				 String guestTel = rs.getString("guest_tel");
				 String guestMail = rs.getString("guest_mail");
				 String guestAddress = rs.getString("guest_address");
				 String reserveId = rs.getString("reserve_id");
				 int numOfAdults = rs.getInt("num_of_adults");
				 int numOfChildren = rs.getInt("num_of_children");
				 String checkin = rs.getString("checkin");
				 int numOfNights = rs.getInt("num_of_nights"); //泊数
				 String reserveDate = rs.getString("reserve_date");
				 int charge= rs.getInt("charge");

				 String reserveMemo = rs.getString("reserve_memo");
				 planName = rs.getString("plan_name");
				 String planImage = rs.getString("plan_image");
				 String planDetail = rs.getString("plan_detail");

				 hotelName = rs.getString("hotel_name");
				 String hotel_address = rs.getString("hotel_address");
				 String hotelTel = rs.getString("hotel_tel");
				 String hotelMail = rs.getString("hotel_mail");
				 String hotelImage = rs.getString("hotel_image");
				 String hotelDetail = rs.getString("hotel_detail");

				 int adultCapacity = rs.getInt("adult_capacity");
				 int childCapacity = rs.getInt("child_capacity");
				 int adultCharge = rs.getInt("adult_charge");
				 int childCharge = rs.getInt("child_charge");

				Reserve reserve = new Reserve(
						guestId,guestName,guestKana, guestBirthday,guestTel,guestMail,guestAddress,
						reserveId,numOfAdults, numOfChildren, checkin, numOfNights, reserveDate, charge,reserveMemo,
						planName, planImage,  planDetail,
						hotelName,hotel_address, hotelTel,  hotelMail, hotelImage,
						hotelDetail,  adultCapacity,childCapacity,  adultCharge, childCharge
						);
				reserveList.add(reserve);
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



	//変更を行うメソッド()
		public void updateReserve(Reserve reserveInfo) {
			Connection conn = null;

			//変更内容の呼び出し
			String reserveId = reserveInfo.getReserveId();
			int numOfAdults = reserveInfo.getNumOfAdults();
			int numOfChildren = reserveInfo.getAdultCharge();;
			int charge = reserveInfo.getCharge();

			//
			System.out.println(reserveId +"\t"+numOfAdults +
					"\t" + numOfChildren +"\t" + charge);

			try {
				Class.forName(DriverName);
				conn = DriverManager.getConnection(JDBCURL, DBUser, DBPass);

				//sql文で変更内容の設定
				String sql = "update reserve_t "+
					"set num_of_children = ?, num_of_adults = ?, charge = ? "+
					"where reserve_id = ? ;";

				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, numOfChildren);
				pStmt.setInt(2, numOfAdults);
				pStmt.setInt(3, charge);
				pStmt.setString(4, reserveId);

				//System.out.println(sql);

				//updateの実行
				pStmt.executeUpdate();

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

		//変更を行うメソッド()
		public void deleteReserve(Reserve reserveInfo) {
			Connection conn = null;

			//変更内容の呼び出し
			String reserveId = reserveInfo.getReserveId();

			try {
				Class.forName(DriverName);
				conn = DriverManager.getConnection(JDBCURL, DBUser, DBPass);

				//sql文で変更内容の設定
				String sql = "delete from reserve_t where reserve_id = ? ;";

				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, reserveId);
				//System.out.println(sql);

				//deleteの実行
				pStmt.executeUpdate();

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

/*  * num_of_adults,num_of_children,checkin,num_of_nights,
 * reserve_date,charge,reserve_memo,plan_name,plan_image,plan_detail,
 * hotel_name,hotel_address,hotel_tel,hotel_mail,hotel_image,
 * hotel_detail,room_type_name,adult_capacity,child_capacity,adult_charge,child_charge	 * */