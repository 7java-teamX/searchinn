package model;

import beans.Admin;
import dao.AdminDAO;


public class AdminLoginLogic {
	public boolean execute(Admin admin) {
		AdminDAO adminDao = new AdminDAO();
		boolean isAdmin = adminDao.findByLogin(admin);
		if(isAdmin) {
			return true;
		}
		return false;
	}
}
