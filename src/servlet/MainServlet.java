package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String action = request.getParameter("action");

		String forward = null;

		/*actionの値に応じてフォワード分岐*/

		if("top".equals(action)) {
			forward = "/jsp/index.jsp";
		}else if("login".equals(action)) {
			forward = "/jsp/guest/guestLogin.jsp";
		}else if("mypage".equals(action)) {
			forward = "/jsp/guest/mypage.jsp";
		}else if("admin".equals(action)) {
			forward = "/jsp/admin/adminLogin.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
		dispatcher.forward(request, response);
	}
}
