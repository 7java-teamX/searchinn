package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AReservetInfoChangeServlet
 */
@WebServlet("/AReservetInfoChangeServlet")
public class AReservetInfoChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String pass = "";

		if(action == null) {
			pass = "aReserveInfoChangeForm.jsp";
		}

		else if(action.equals("done")) {
			//変更確定の処理
			pass = "aReserveInfoChangeDone.jsp";
		}

		//aReserveList.jspのフォワード処理
		RequestDispatcher dis = request.getRequestDispatcher(pass);
		dis.forward(request,response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//aReserveList.jspのフォワード処理
		RequestDispatcher dis = request.getRequestDispatcher("aReserveInfoChangeConfirm.jsp");
		dis.forward(request,response);
	}

}
