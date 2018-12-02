package model;

import java.util.List;

import dao.PlanDAO;

public class HotelSelectLogic {
	public List<Plan> execute(String hotelId){
		PlanDAO dao = new PlanDAO();
		List<Plan> planList = dao.selectByHotelId(Integer.parseInt(hotelId));
		return planList;
	}

}
