package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Reserve;
import model.ReserveShowLogic;

/**
 * Servlet implementation class AReservetInfoChangeServlet
 */
@WebServlet("/AReserveInfoChangeServlet")
public class AReserveInfoChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String pass = "";

		if(action == null) {
			pass = "aReserveInfoChangeForm.jsp";
		}
		else if(action.equals("done")) {
			//変更確定の処理
			HttpSession session = request.getSession();
			Reserve reserveInfo = (Reserve)session.getAttribute("reserveInfo");
			ReserveShowLogic rSL = new ReserveShowLogic();
			rSL.excecute2(reserveInfo);
			pass = "aReserveInfoChangeDone.jsp";
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

		//session-scopeの取得
		HttpSession session = request.getSession();
		Reserve reserveInfo = (Reserve)session.getAttribute("reserveInfo");

		//合計金額の計算を行う (大人人数*料金+子供人数*子供料金)*泊数
		int charge = (numOfAdults *reserveInfo.getAdultCharge()+ numOfChildren * reserveInfo.getChildCharge())
				* reserveInfo.getNumOfNights();

		reserveInfo.setCharge(charge);
		reserveInfo.setNumOfAdults(numOfAdults);
		reserveInfo.setNumOfChildren(numOfChildren);

		//session-scopeに予約詳細を格納
		session.setAttribute("reserveInfo", reserveInfo);

		//aReserveList.jspのフォワード処理
		RequestDispatcher dis = request.getRequestDispatcher("aReserveInfoChangeConfirm.jsp");
		dis.forward(request,response);
	}

}
