package model;

import beans.Guest;
import dao.AlterGuestDAO;

public class GuestAlterLogic {
	AlterGuestDAO alterGuestDAO= new AlterGuestDAO();
	public void delete(int id){
		alterGuestDAO.delete(id);

	}
	public void update(Guest guest) {
		 alterGuestDAO.update(guest);
	}
}
