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
		String fowardPath ="null";

		if(action.equals("done")) {
			fowardPath ="/jsp/guest/registerGuestDone.jsp";
		}
		else if(action.equals("null")){
			fowardPath ="/jsp/guest/registerGuestForm.jsp";
		}
		//フォワード
		RequestDispatcher dis =request.getRequestDispatcher(fowardPath);
		dis.forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		int guestId = request.getParameter("guestId");
		String name = request.getParameter("guestName");
		String kana = request.getParameter("guestKana");
		String birthday = request.getParameter("guestBirthday");
		String pass = request.getParameter("guestPass");
		String tel = request.getParameter("guestTel");
		String mail = request.getParameter("guestMail");
		String address = request.getParameter("guestAddress");

		//登録するユーザーの情報を設定
		Guest registerGuest = new Guest(guestId, name, kana, birthday, pass, tel, mail, address);

		//セッションスコープに登録ユーザーを保存
		HttpSession session = request.getSession();
		session.setAttribute("registerGuest", registerGuest);

		//フォワード
		RequestDispatcher dis = request.getRequestDispatcher("/searchinn/registerGuestConfirm.jsp");
		dis.forward(request, response);*/
	}
}
