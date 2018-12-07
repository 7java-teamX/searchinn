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

import beans.Guest;
import model.GuestShowLogic;

/**
 * Servlet implementation class aGuestListServlet
 */
/**
 * @author 3BC1_12
 *
 */
@WebServlet("/AGuestListServlet")
public class AGuestListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
	System.out.println(action);
		if (action != null && action.equals("list")) {
			System.out.println("aGuestListServlet");
			GuestShowLogic guestShowLogic = new GuestShowLogic();
			List<Guest> guestList = guestShowLogic.showAll();
			System.out.println("dbからデータを取得");
			//ユーザー情報一覧をセッションスコープに保存
			HttpSession ses = request.getSession();
			ses.setAttribute("guestList", guestList);
			System.out.println("AGuestListServlet: if");
		}
		RequestDispatcher dis = request.getRequestDispatcher("/aGuestList.jsp");
		dis.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
