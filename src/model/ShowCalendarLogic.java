package model;

import java.util.Map;

import dao.ReserveDAO;

public class ShowCalendarLogic {
	public Map<String, Object> execute(int planId, String ym) {
		ReserveDAO dao = new ReserveDAO();
		CalendarMake cm = new CalendarMake();
		Map<String, Object> calMap = cm.calMake(ym, dao.countReserveDate(planId, ym));
		return calMap;
	}
}
