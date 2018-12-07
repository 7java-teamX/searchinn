package model;

import java.util.List;

import beans.Reserve;
import dao.ReserveShowDAO;

public class ReserveShowLogic {
	//管理者用予約管理ロジック
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
