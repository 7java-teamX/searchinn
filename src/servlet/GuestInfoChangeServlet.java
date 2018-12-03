package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Guest;
/**
* @author 3BC1_12
*
*/
/**
 * Servlet implementation class GuestInfoChangeServlet
 */

@WebServlet("/GuestInfoChangeServlet")
public class GuestInfoChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");
		int guestId = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String kana = request.getParameter("kana");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		Guest guest = new Guest(guestId,name,kana,tel,email);

	}

}
