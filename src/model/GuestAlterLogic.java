package model;

public class GuestAlterLogic {
	public boolean delete{
		AlterGuestDAO alterGuestDAO= new AlterGuestDAO;
		boolean delete = alterGuestDAO.delete();

	}
}
