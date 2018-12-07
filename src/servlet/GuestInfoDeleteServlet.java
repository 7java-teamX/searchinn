package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Guest;
import model.GuestAlterLogic;

/**
 * Servlet implementation class GuestInfoDeleteServlet
 */
@WebServlet("/GuestInfoDeleteServlet")
public class GuestInfoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		Guest guest = (Guest) ses.getAttribute("guestDetail");
		int id = guest.getGuestId();
		GuestAlterLogic guestAlterLogic = new GuestAlterLogic();
		guestAlterLogic.delete(id);
		RequestDispatcher dis = request.getRequestDispatcher("/aGuestInfoDeleteDone.jsp");
		dis.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
