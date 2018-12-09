package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import beans.SalesInfo;
import dao.ReserveSalesDAO;

public class SalesLogic {
	public Map<String, List<SalesInfo>> execute(String term) {
		System.out.println("Logic開始");
		System.out.println(term);
		Map<String, List<SalesInfo>> salesMap = new HashMap<>();
		ReserveSalesDAO dao = new ReserveSalesDAO();
		salesMap.put("hotelSales", dao.hotelSales(term));
		salesMap.put("areaSales", dao.areaSales(term));
		salesMap.put("totalSales", dao.totalSales(term));

		return salesMap;
	}
}
