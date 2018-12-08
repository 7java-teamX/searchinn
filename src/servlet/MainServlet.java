package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 3BC1_12
 *
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");

		String forward = null;

		/*actionの値に応じてフォワード分岐*/

		if(action.equals("top")) {
			forward = "/index.jsp";
		}else if(action.equals("login")) {
			forward = "/WEB-INF/jsp/guest/login_register/guestLogin.jsp";
		}else if(action.equals("mypage")) {
			forward = "/WEB-INF/jsp/guest//mypage/mypage.jsp";
		}else if(action.equals("admin")) {
			forward = "/WEB-INF/jsp/admin/adminLogin.jsp";
		}else if(action.equals("reserve")) {
			forward = "/WEB-INF/jsp/guest/reserve/hotel.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
		dispatcher.forward(request, response);
	}
}
