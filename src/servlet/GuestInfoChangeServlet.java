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
import model.RegisterGuestLogic;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		HttpSession ses = request.getSession();
		if (action.equals("change")) {
			RequestDispatcher dis = request
					.getRequestDispatcher("/WEB-INF/jsp/admin/guestList/aGuestInfoChangeForm.jsp");
			dis.forward(request, response);
		} else {
			Guest guest = (Guest) ses.getAttribute("update");
			RegisterGuestLogic registerGuestLogic = new RegisterGuestLogic();
			boolean isCheck = registerGuestLogic.isCheck(guest);
			if (isCheck) {
				GuestAlterLogic guestAlterLogic = new GuestAlterLogic();
				//ユーザー情報の変更実行
				guestAlterLogic.update(guest);
			}else {
				request.setAttribute("Msg", "メールアドレスが重複しています");
				RequestDispatcher dis =
						request.getRequestDispatcher("/WEB-INF/jsp/admin/guestList/aGuestInfoChangeForm.jsp");
				dis.forward(request, response);
			}
			if (action.equals("guest")) {
				ses.setAttribute("loginUser", guest);
				RequestDispatcher dis = request
						.getRequestDispatcher("/WEB-INF/jsp/guest/mypage/guestInfo/gGuestInfoChangeDone.jsp");
				dis.forward(request, response);
			} else if (action.equals("admin")) {
				RequestDispatcher dis = request
						.getRequestDispatcher("/WEB-INF/jsp/admin/guestList/aGuestInfoChangeDone.jsp");
				dis.forward(request, response);
			}
		}

	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");
		int guestId = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String kana = request.getParameter("kana");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String action = request.getParameter("action");
		Guest guest = new Guest(guestId, name, kana, tel, email, address);
		HttpSession ses = request.getSession();
		ses.setAttribute("update", guest);
		System.out.println(action);
		if (action.equals("guest")) {
			RequestDispatcher dis = request
					.getRequestDispatcher("/WEB-INF/jsp/guest/mypage/guestInfo/gGuestInfoChangeConfirm.jsp");
			dis.forward(request, response);
		} else if (action.equals("admin")) {
			RequestDispatcher dis = request
					.getRequestDispatcher("/WEB-INF/jsp/admin/guestList/aGuestInfoChangeConfirm.jsp");
			dis.forward(request, response);
		}
	}

}
