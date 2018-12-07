package model;

import java.util.List;

import beans.Reserve;
import dao.GReserveShowDAO;
//ゲスト用予約管理ロジック

public class GReserveShowLogic {
	//
	public List<Reserve> excecute(int guestId){
		GReserveShowDAO dao = new GReserveShowDAO();
		List<Reserve> reserveList = dao.selectReserve(guestId);
		return reserveList;
	}
	//update実行時
	public void excecute2(Reserve reserveInfo){
		GReserveShowDAO dao = new GReserveShowDAO();
		dao.updateReserve(reserveInfo);

	}
	//delete実行時
	public void excecute3(int reserveId){
		GReserveShowDAO dao = new GReserveShowDAO();
		dao.deleteReserve(reserveId);
	}

}
