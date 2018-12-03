package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ReserveDateLogic {
	//⑤実際に宿泊数に応じて 格納する日付を加算しString型に収める
	public String forDayAdd(String day,int count) {
		String strday = "";
		strday += day;
		//宿泊が2日以上の場合
		if(count > 1) {
			for(int i = 0; i < count-1; i++) {
				Date date = dateChange(day) ;  //①String型の 2018-01-01 を Date型に変換
				Calendar cl = calendarChange(date);   //②Date型からカレンダー型に変換
				cl =calendarAdd(cl);    //③１日加算
				day = strChange(cl); //④カレンダー型をyyyy-MM-dd フォーマット設定
				strday += ","+ day;
			}
		}
		System.out.println(strday);
		return strday;
	}
//①String型の 2018-01-01 を Date型に変換
	public static Date dateChange(String day) {
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
		return date;
	}

	//②DateクラスからCalendarクラスに変換 return cl
	public static Calendar calendarChange(Date date) {
		Calendar cl = Calendar.getInstance();
		cl.setTime(date);
		 //System.out.println("②カレンダー型変換:"+ cl.getTime().toString());
		return cl;
	}

	//③１日加算させる
	public static Calendar calendarAdd(Calendar cl){
		cl.add(Calendar.DAY_OF_MONTH, 1);
		//System.out.println("③１日加算 : "+cl.getTime());
		return cl;
	}

	//④カレンダー型をyyyy-MM-dd フォーマット設定
	public static String strChange(Calendar cl) {
		//String day = String.valueOf(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strday = sdf.format(cl.getTime());
      //System.out.println("④文字列変換完了 : " + strday);
      return strday;
	}
}