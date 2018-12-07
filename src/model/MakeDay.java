package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MakeDay {
	/*public static void main(String []args) {
		makeToday();
		make3Month();
	}*/

	public  String makeToday(){
		Date day = new Date();
		String strDay ="";
        strDay = new SimpleDateFormat("yyyy-MM-dd").format(day);
        System.out.println("今日の日付 : "+strDay);
		return strDay;
	}

	public  String make3Month() {
		Calendar cl = Calendar.getInstance();
		cl.add(Calendar.MONTH, 3);
		String afterDay= new SimpleDateFormat("yyyy-MM-dd").format(cl.getTime());
		System.out.println("3カ月後の日付 : "+ afterDay);
		return afterDay;

	}

}
