package model;

import java.util.HashMap;
import java.util.Map;

import dao.AreaDAO;
import dao.HotelDAO;
import dao.PlanDAO;
import dao.RoomTypeDAO;

public class ShowFacilityLogic {
	public Map<String, Object> execute(){
		Map<String, Object> facilityMap = new HashMap<>();
		AreaDAO adao = new AreaDAO();
		HotelDAO hdao = new HotelDAO();
		PlanDAO pdao = new PlanDAO();
		RoomTypeDAO rdao = new RoomTypeDAO();

		facilityMap.put("area", adao.showAll());
		facilityMap.put("hotel", hdao.showAll());
		facilityMap.put("plan", pdao.showAll());
		facilityMap.put("roomType", rdao.showAll());

		return facilityMap;
	}



}
