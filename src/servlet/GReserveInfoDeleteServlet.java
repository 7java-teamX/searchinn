package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GReserveShowLogic;

/**
 * Servlet implementation class AReserveInfoDeleteServlet
 */
@WebServlet("/GReserveInfoDeleteServlet")
public class GReserveInfoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// reserveIdを取得
		request.setCharacterEncoding("UTF-8");
		int reserveId = Integer.parseInt(request.getParameter("reserveId"));
		System.out.println(reserveId);

		//予約削除の実行
		GReserveShowLogic rSL = new GReserveShowLogic();
		rSL.excecute3(reserveId);

		//予約削除後にsession-scopeからreserveInfoインスタンスを破棄
		HttpSession session = request.getSession();
		session.removeAttribute("reserveInfo");

		//フォワード処理
		//aReserveList.jspのフォワード処理
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/guest/mypage/reserve/gReserveCancelDone.jsp");
		dis.forward(request,response);
	}

}
