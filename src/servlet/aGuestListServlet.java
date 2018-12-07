package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class aGuestListServlet
 */
@WebServlet("/aGuestListServlet")
public class aGuestListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession ses = request.getSession();
//		List<Guest> guestList = (List<Guest>) ses.getAttribute("criteria", List<Guest>);
//
//
//		if(guestList.size() == 0) {
//			//ないとき
//			GuestShowLogic gShowLogic = new GuestShowLogic();
//			List<Guest> guestList = gShowLogic.showAll();
//		}
//			//ある時
//

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
