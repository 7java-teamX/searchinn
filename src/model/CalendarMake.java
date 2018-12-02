package model;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class CalendarMake {

	public Map<String, Object> calMake(String ym){
		Map<String, Object> calMap = new HashMap<>();
		int year;
		int month;
		int startdayOfWeek;
		int lastdayOfMonth;

		//  カレンダーの取得
		Calendar cal = Calendar.getInstance();
		//  年月が入力されていればその値，入力がなければ現在の年月を設定
		if(ym == null || ym.equals("")){
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH)+1;
		}else{
			String[] ymArr = ym.split("-");
			year = Integer.parseInt(ymArr[0]);
			month = Integer.parseInt(ymArr[1]);
		}
		//Mapにセット
		calMap.put("ym", ym);
		calMap.put("year", year);
		calMap.put("month", month);

		// 月初めの曜日(日-> 1)
		cal.set(year, month - 1, 1);
		startdayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
//		System.out.println("l60:startdayOfWeek" + startdayOfWeek);
		// 月末の日付
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DATE, -1);
		lastdayOfMonth = cal.get(Calendar.DATE);
//		System.out.println("l65:lastdayOfMonth" + lastdayOfMonth);
		//  カレンダーのデータを作成する
		int date = 1;
		int maxday = 7 * 6;
		StringBuilder sb = new StringBuilder();
		sb.append("<table>");
		sb.append("<tr>");
		sb.append("<th>日</th>");
		sb.append("<th>月</th><th>火</th><th>水</th><th>木</th><th>金</th>");
		sb.append("<th>土</th>");
		sb.append("</tr>");
		sb.append("<tr>");

		// num はカレンダー内のマス番号(最大42(maxday)) lastdayOfMonth + startdayOfWeek - 1 は最低必要マス数(該当月の日数＋1日より前の空白マス数)
		for (int num = 1; num <= maxday; num++) {
			// startdayOfWeekより前とlastdayOfMonthより後にはdateを入れずに空白のマスを表示する
			if(num < startdayOfWeek || num > lastdayOfMonth + startdayOfWeek - 1){
				sb.append("<td></td>");
			}else{
				sb.append("<td>"+date+"</td>");
				date++;
			}
			// 7マスごとにカレンダーを改行
			if(num % 7 == 0){
				sb.append("</tr>");
				// lastdayOfMonthに達していればループを抜ける
				if(num >= lastdayOfMonth + startdayOfWeek- 1){
					break;
				}else {
					sb.append("<tr>");
				}
			}
		}
		sb.append("</table>");
		//  パラメータを設定
		calMap.put("calendar", sb);
		return calMap;
	}
}
