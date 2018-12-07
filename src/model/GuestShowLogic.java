package model;

import java.util.List;

import beans.Guest;
import dao.GuestShowDAO;


/**
 * @author 3BC1_12
 *
 */
public class GuestShowLogic {
	GuestShowDAO guestShowDAO = new GuestShowDAO();
	public List<Guest> showAll(){
		//GuestShowDAO guestShowDAO = new GuestShowDAO();
		List<Guest> guestList = guestShowDAO.showAll();

		return guestList;
	}
	public List<Guest> refineSearch(Guest criteria){
		//GuestShowDAO guestShowDAO = new GuestShowDAO();
		List<Guest> guestList = guestShowDAO.refineSearch(criteria);
		return guestList;
	}
	public Guest detailSearch(int id) {
		return guestShowDAO.detailSearch(id);
	}
}
