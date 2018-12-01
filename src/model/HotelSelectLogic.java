package model;

import java.util.List;

import dao.HotelDAO;

public class HotelSelectLogic {
	public List<Plan> execute(String hotelId){
		HotelDAO dao = new HotelDAO();
		List<Plan> planList = dao.selectByHotelId(Integer.parseInt(hotelId));
		return planList;
	}

}
