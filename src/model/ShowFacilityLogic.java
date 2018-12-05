package model;

import java.util.HashMap;
import java.util.Map;

import dao.AreaDAO;
import dao.PlanDAO;

public class ShowFacilityLogic {
	Map<String, Object> facilityMap = new HashMap<>();
	AreaDAO adao = new AreaDAO();
	HotelDAO hdao = new HotelDAO();
	PlanDAO pdao = new PlanDAO();

}
