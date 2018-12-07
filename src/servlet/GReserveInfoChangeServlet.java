package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Reserve;
import model.GReserveShowLogic;


@WebServlet("/GReserveInfoChangeServlet")
public class GReserveInfoChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String strIndex = request.getParameter("index");
		String pass = "";

		//session-scopeの取得
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Reserve> reserveList = (List<Reserve>)session.getAttribute("reserveList");


		if(strIndex.equals("done")) {
			//変更確定の処理
			Reserve reserveInfo = (Reserve)session.getAttribute("reserveInfo");
			GReserveShowLogic rSL = new GReserveShowLogic();
			rSL.excecute2(reserveInfo);
			pass = "gReserveChangeDone.jsp";
			//session.remove
		}
		else if(strIndex != null) {
			int index = Integer.parseInt(strIndex);

			// indexの数値を元にarrayListから取得しsession-scopeに格納
			Reserve reserveInfo = reserveList.get(index);
			session.setAttribute("reserveInfo", reserveInfo);
			pass = "gReserveChangeForm.jsp";
		}

		//aReserveList.jspのフォワード処理
		RequestDispatcher dis = request.getRequestDispatcher(pass);
		dis.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		int numOfAdults = Integer.parseInt(request.getParameter("numOfAdult"));
		int numOfChildren = Integer.parseInt(request.getParameter("numOfChild"));
		String reserveMemo = request.getParameter("reserveMemo");

		//session-scopeの取得
		HttpSession session = request.getSession();
		Reserve reserveInfo = (Reserve)session.getAttribute("reserveInfo");

		//合計金額の計算を行う (大人人数*料金+子供人数*子供料金)*泊数
		int charge = (numOfAdults *reserveInfo.getAdultCharge()+ numOfChildren * reserveInfo.getChildCharge())
				* reserveInfo.getNumOfNights();

		reserveInfo.setCharge(charge);
		reserveInfo.setNumOfAdults(numOfAdults);
		reserveInfo.setNumOfChildren(numOfChildren);
		reserveInfo.setReserveMemo(reserveMemo);

		//session-scopeに予約詳細を格納
		session.setAttribute("reserveInfo", reserveInfo);

		//aReserveList.jspのフォワード処理
		RequestDispatcher dis = request.getRequestDispatcher("gReserveChangeConfirm.jsp");
		dis.forward(request,response);
	}

}
