package model;

import beans.RoomType;
import dao.RoomTypeDAO;

public class RoomTypeEditLogic {
	public void update(RoomType roomType ) {
		RoomTypeDAO rtDAO = new RoomTypeDAO();
		rtDAO.update(roomType);
	}
	public void insert(RoomType roomType ) {
	RoomTypeDAO rtDAO = new RoomTypeDAO();
	rtDAO.insert(roomType);
}
}
