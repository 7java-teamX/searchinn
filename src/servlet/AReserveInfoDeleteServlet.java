package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Reserve;
import model.ReserveShowLogic;

/**
 * Servlet implementation class AReserveInfoDeleteServlet
 */
@WebServlet("/AReserveInfoDeleteServlet")
public class AReserveInfoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Reserve reserveInfo = (Reserve)session.getAttribute("reserveInfo");
		ReserveShowLogic rSL = new ReserveShowLogic();
		rSL.excecute3(reserveInfo);

		//session-scopeからreserveInfoインスタンスを破棄
		session.removeAttribute("reserveInfo");

		//フォワード処理
		//aReserveList.jspのフォワード処理
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/admin/reserveList/aReserveCancelDone.jsp");
		dis.forward(request,response);
	}

}
