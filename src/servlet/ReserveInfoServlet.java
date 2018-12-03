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

@WebServlet("/ReserveInfoServlet")
public class ReserveInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String day = request.getParameter("day");
		String hotelName = request.getParameter("hotelName");
		String planName = request.getParameter("planName");
		String guestName = request.getParameter("guestName");

		//検索条件をインスタンスに格納
		Reserve refineSearch = new Reserve(day,hotelName,planName,guestName);

		//セッションスコープに格納
		HttpSession session = request.getSession();
		session.setAttribute("refineSearch", refineSearch);

		//aReserveList.jspのフォワード処理
		RequestDispatcher dis = request.getRequestDispatcher("/AReserveListServlet");
		dis.forward(request,response);


	}

}
