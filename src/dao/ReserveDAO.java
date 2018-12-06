package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ReserveDAO {
	public int[] countReserveDate(int planId, String ym) {
		Connection conn = null;
		String DRIVER_NAME ="com.mysql.jdbc.Driver" ;
		String JDBC_URL = "jdbc:mysql://localhost:3306/inn";
		String DB_user = "root";
		//String DR_pass = "root";
		String DR_pass = "Reina9110Nao";

		int reserveMax[] = new int[31];
		int reserveCount[] = new int[31];  //最大31日まで部屋の予約数を配列で格納
		int roomAvailable[] = new int[31];
		String firstDay = ym + "-01";    	//当月の月初の日付をString型で格納
		int numDays = countDays(firstDay);;  					//当月の月末の日付をint型で格納

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL,DB_user,DR_pass);

			for(int i=0; i < numDays; i++){
				String iDate = StrDateAdd(firstDay,i); //forでi日加算 初期は0加算

				//部屋の最大数 sql(select num_of_rooms from plan_t where plan_id = 1);
				//SELECT文の準備(forで reserve_date likeの値は増加していく)
				String sql ="SELECT (SELECT DISTINCT num_of_rooms FROM plan_t),count(*),(SELECT DISTINCT num_of_rooms FROM plan_t)-count(*)"
						+ " FROM reserve_t"
						+ " JOIN plan_t"
						+ " ON reserve_t.plan_id=plan_t.plan_id"
						+ " WHERE reserve_t.plan_id = ? AND reserve_date LIKE ?";
				PreparedStatement pSmt = conn.prepareStatement(sql);
				pSmt.setInt(1, planId);
				pSmt.setString(2, "%"+ iDate +"%");
				ResultSet rs = pSmt.executeQuery();

				//SELECT文の結果を配列に格納
				if(rs.next()) {
					int max = rs.getInt("(SELECT DISTINCT num_of_rooms FROM plan_t)");
					int count = rs.getInt("count(*)");
					int available = rs.getInt("(SELECT DISTINCT num_of_rooms FROM plan_t)-count(*)");

					reserveMax[i] = max; //配列のi番目に格納
					reserveCount[i] = count; //配列のi番目に格納
					roomAvailable[i] = available;
				}// if
			}// for
		}//try
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		catch(SQLException se) {
			se.printStackTrace();
			return null;
		}
		finally {
			if(conn != null) {
				try {
					conn.close(); //DBMSの JDBC リソースを解除
				}
				catch(SQLException se) {
					se.printStackTrace();
					return null;
				}
			}
		} //finally
	//テスト用
		/*
			for (int i = 0; i < reserveCount.length; i++) {
		System.out.println(i + "最大" + reserveMax[i]);
			System.out.println(i + "予約数" + reserveCount[i]);
				System.out.println(i + "空き" + roomAvailable[i]);
		}*/
		return roomAvailable;
	} // countReserveDate() fin


	//予約の重複を確認する
	public List<Integer> reserveDays(int planId,String checkin,int numOfNights){

		Connection conn = null;
		String DRIVER_NAME ="com.mysql.jdbc.Driver" ;
		String JDBC_URL = "jdbc:mysql://localhost:3306/inn";
		String DB_user = "root";
		//String DR_pass = "root";
		String DR_pass = "Reina9110Nao";

		//配列では固定長のため可変長利用する
		List<Integer> roomNumList = new ArrayList<>();

		//チェックイン日時と泊数を元にしてレコードを抽出し、配列に格納
		//泊数に限界がある場合は１日加算して再度selectを行う

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL,DB_user,DR_pass);

			for(int i=0; i < numOfNights; i++){
				String iDate = StrDateAdd(checkin,i); //forでi日加算 初期は0加算
				System.out.println("iDate : " + iDate);

				//部屋の最大数 sql(select num_of_rooms from plan_t where plan_id = 1);
				//SELECT文の準備(forで reserve_date likeの値は増加していく)
				String sql ="SELECT "
						+ " (SELECT DISTINCT num_of_rooms FROM plan_t)-count(*)"
						+ " FROM reserve_t"
						+ " JOIN plan_t"
						+ " ON reserve_t.plan_id=plan_t.plan_id"
						+ " WHERE reserve_t.plan_id = ? AND reserve_date LIKE ?";
				PreparedStatement pSmt = conn.prepareStatement(sql);
				pSmt.setInt(1, planId);
				pSmt.setString(2, "%"+ iDate +"%");
				ResultSet rs = pSmt.executeQuery();

				//SELECT文の結果を配列に格納
				if(rs.next()) {
					// 対象プランでの空き室数
					int reserveDays = rs.getInt("(SELECT DISTINCT num_of_rooms FROM plan_t)-count(*)");
					roomNumList.add(reserveDays);
				}// if
			}// for
		}//try
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		catch(SQLException se) {
			se.printStackTrace();
			return null;
		}
		finally {
			if(conn != null) {
				try {
					conn.close(); //DBMSの JDBC リソースを解除
				}
				catch(SQLException se) {
					se.printStackTrace();
					return null;
				}
			}
		} //finally
		//テスト用
		int i = 0;
		for(int reserveDays:roomNumList){
			System.out.println(i++ +"日目"+ reserveDays);
		}

		return roomNumList;
	}




	//String firstDayから最終日をint型で返す　
	public static int countDays(String firstDay) {
		Date date = new Date(); //
		try {
			//SimpleDateFomat
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			date = sdf.parse(firstDay);
			//System.out.println("①Date型変換: " +  date);
		}
		catch(ParseException pE) {
			pE.printStackTrace();
		}
		Calendar cl = Calendar.getInstance();
		cl.setTime(date);
		int numDays = cl.getActualMaximum(Calendar.DAY_OF_MONTH);
		 //System.out.println("②カレンダー型変換:"+ cl.getTime().toString());
		return numDays;
	}

	// finalで宣言


	//部屋ごとの予約数を抽出するメソッド
	//input type="month"から利用

	//String型の 2018-01-01 を Date型→Calendar型→1日加算→Strig型で返す
	public static String StrDateAdd(String day,int i) {
		Date date = new Date();
		try {
			//SimpleDateFomat
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			date = sdf.parse(day);
			//System.out.println("①Date型変換: " +  date);
		}
		catch(ParseException pE) {
			pE.printStackTrace();
		}

		//②DateクラスからCalendarクラスに変換 return cl
		Calendar cl = Calendar.getInstance();
		cl.setTime(date);

		//③１日加算させる
		cl.add(Calendar.DAY_OF_MONTH, i);
		//System.out.println("③１日加算 : "+cl.getTime());

		//④カレンダー型をyyyy-MM-dd フォーマット設定
		//String day = String.valueOf(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strday = sdf.format(cl.getTime());
		//System.out.println("④文字列変換完了 : " + strday);
		return strday;
	}
}
