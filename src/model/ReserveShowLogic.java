package model;

import java.util.List;

import dao.ReserveShowDAO;

public class ReserveShowLogic {
	//
	public List<Reserve> excecute(Reserve refineSearch){
		ReserveShowDAO dao = new ReserveShowDAO();
		List<Reserve> reserveList = dao.selectReserve(refineSearch);
		return reserveList;

	}
	//update実行時
	public void excecute2(Reserve reserveInfo){
		ReserveShowDAO dao = new ReserveShowDAO();
		dao.updateReserve(reserveInfo);

	}
	//delete実行時
	public void excecute3(Reserve refineSearch){
		ReserveShowDAO dao = new ReserveShowDAO();
		dao.deleteReserve(refineSearch);

	}

}
