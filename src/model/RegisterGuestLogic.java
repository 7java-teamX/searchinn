package model;

import dao.GuestDAO;

public class RegisterGuestLogic {
	GuestDAO guestDAO = new GuestDAO();

	public boolean isCheck(Guest guest) {

		boolean isCheck = guestDAO.registerCheck(guest);

		return isCheck;
	}

	public boolean isInsert(Guest guest) {
		guestDAO.registerInsert(guest);
		return true;
	}
}
