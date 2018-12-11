package model;

import java.util.List;

import dao.ReserveDAO;
//
public class ReserveCheck {
	public boolean checkReserve(int planId,String checkin,int numOfNights){
		  boolean bool = true; //初期値true
		  ReserveDAO dao = new ReserveDAO();
		  List<Integer> roomNumList = dao.reserveDays(planId,checkin,numOfNights);
		  for(int reserveDays:roomNumList){
		    if(reserveDays == 0 ){
		      bool = false;
		    }
		  }
		  return bool;
		}

}
