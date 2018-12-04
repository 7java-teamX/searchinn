package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.ReserveSalesDAO;

public class ShowSalesLogic {
	public Map<String, List<SalesInfo>> execute(String term) {
		System.out.println("Logic開始");
		System.out.println(term);
		Map<String, List<SalesInfo>> salesMap = new HashMap<>();
		ReserveSalesDAO dao = new ReserveSalesDAO();
		salesMap.put("hotelSales", dao.hotelSales(term));
		salesMap.put("areaSales", dao.areaSales(term));
		salesMap.put("totalSales", dao.totalSales(term));
		System.out.println("l16" + salesMap.size());
		System.out.println("l17" + salesMap.get("hotelSales"));
		System.out.println("l18" + salesMap.get("hotelSales").size());
		System.out.println("l19" + salesMap.get("hotelSales").get(2));
		return salesMap;
	}
}
