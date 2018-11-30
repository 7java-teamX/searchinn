package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterGuestServlet
 */
@WebServlet("/RegisterGuestServlet")
public class RegisterGuestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		// actionで分岐
		String action = request.getParameter("action");
		String fowardPath ="";

		if(action.equals("done")) {
			fowardPath ="/registerGuestDone.jsp";
		}
		else {
			fowardPath ="/registerGuestForm.jsp";
		}
		//フォワード
		RequestDispatcher dis =request.getRequestDispatcher(fowardPath);
		dis.forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
	}
}
