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

import model.Guest;
import model.GuestShowLogic;

/**
 * Servlet implementation class aGuestListServlet
 */
/**
 * @author 3BC1_12
 *
 */
@WebServlet("/aGuestListServlet")
public class AGuestListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		GuestShowLogic guestShowLogic = new GuestShowLogic();
		List<Guest> guestList = guestShowLogic.showAll();
		//ユーザー情報一覧をセッションスコープに保存
		HttpSession ses = request.getSession();
		ses.setAttribute("guestList", guestList);
		RequestDispatcher dis = request.getRequestDispatcher("/aGuestList.jsp");
		dis.forward(request, response);

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
