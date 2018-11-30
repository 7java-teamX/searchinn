package model;

import java.util.List;

import dao.GuestShowDAO;

public class GuestShowLogic {
	public List<Guest> showAll(){
		GuestShowDAO guestShowDAO = new GuestShowDAO();
		List<Guest> guestList = guestShowDAO.showAll();

		return guestList;
	}
}
