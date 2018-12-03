package model;

import java.util.List;

import dao.ReserveShowDAO;

public class ReserveShowLogic {
	public List<Reserve> excecute(Reserve refineSearch){
		ReserveShowDAO dao = new ReserveShowDAO();
		List<Reserve> reserveList = dao.selectReserve(refineSearch);
		return reserveList;

	}

}
