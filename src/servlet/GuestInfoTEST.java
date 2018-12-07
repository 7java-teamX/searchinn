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

/**
 * Servlet implementation class GuestInfoTEST
 */
@WebServlet("/GuestInfoTEST")
public class GuestInfoTEST extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 1;
		String name = "松野英治 ";
		String kana = "マツノエイジ ";
		String birthday = "1990-08-21";
		//String pass = "1990-08-21";
		String tel = "08096796401";
		String mail = "0001@sample.ne.jp";
		String address = "広島県呉市東三津田町";
		Guest guest = new Guest(id,  name,  kana,  birthday,  tel, mail,  address);
		HttpSession ses = request.getSession();
		ses.setAttribute("loginUser",guest );
		RequestDispatcher dis = request.getRequestDispatcher("/gGuestInfo.jsp");
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
