package model;

import dao.ReserveInsertDAO;

public class ReserveDoneLogic {
	public void execute(Reserve reserve) {
		ReserveInsertDAO dao = new ReserveInsertDAO();
		dao.insert(reserve);
	}
}
