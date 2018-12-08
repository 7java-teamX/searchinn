package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GGuestInfoServlet
 */
@WebServlet("/GGuestInfoServlet")
public class GGuestInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String path = null;
		String action = request.getParameter("action");
		if(action != null) {
			switch (action) {
			case "info":
				path = "/WEB-INF/jsp/guest//mypage/guestInfo/gGuestInfo.jsp";
				break;

			case "edit":
				path = "/WEB-INF/jsp/guest//mypage/guestInfo/gGuestInfoChangeForm.jsp";
				break;

			case "confirm":
				path = "/WEB-INF/jsp/guest//mypage/guestInfo/gGuestInfoChangeForm.jsp";
				break;
			}
		}


		RequestDispatcher dis = request.getRequestDispatcher(path);
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
