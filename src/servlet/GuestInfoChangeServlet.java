package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Guest;
import model.GuestAlterLogic;
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
		HttpSession ses = request.getSession();
		Guest guest = (Guest) ses.getAttribute("update");
		GuestAlterLogic guestAlterLogic = new GuestAlterLogic();
		//ユーザー情報の変更実行
		guestAlterLogic.update(guest);

		RequestDispatcher dis = request.getRequestDispatcher("/aGuestInfoChangeDone.jsp");
		dis.forward(request, response);

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
		String address = request.getParameter("address");
		String email = request.getParameter("email");

		Guest guest = new Guest(guestId,name,kana,tel,email,address);
		HttpSession ses = request.getSession();
		ses.setAttribute("update", guest);
		RequestDispatcher dis = request.getRequestDispatcher("/aGuestInfoChangeConfirm.jsp");
		dis.forward(request, response);
}

}
