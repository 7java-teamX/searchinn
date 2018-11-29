package model;

import java.util.List;

import DAO.GuestShowDAO;

public class GuestShowLogic {
	public List<Guest> showAll(){
		GuestShowDAO guestShowDAO = new GuestShowDAO();
		List<Guest> guestList = guestShowDAO.showAll();

		return guestList;
	}
}
