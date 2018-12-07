package model;

import beans.Guest;
import dao.GuestDAO;

public class GuestLoginLogic {
	public boolean execute(Guest guest) {
		GuestDAO dao = new GuestDAO();
		boolean isExist = dao.selectLogin(guest);
		if(isExist) {
			return true;
		}
		return false;
	}
}
