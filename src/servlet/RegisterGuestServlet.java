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
import model.RegisterGuestLogic;

@WebServlet("/RegisterGuestServlet")
public class RegisterGuestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		// actionで分岐
		String action = request.getParameter("action");
		String fowardPath = "null";

		if (action.equals("done")) {
			HttpSession ses = request.getSession();
			Guest insertGuest = (Guest) ses.getAttribute("loginGuest");
			RegisterGuestLogic registerGuestLogic = new RegisterGuestLogic();
			registerGuestLogic.isInsert(insertGuest);

			fowardPath = "/jsp/guest/registerGuestDone.jsp";
		} else if (action.equals("null")) {
			fowardPath = "/jsp/guest/registerGuestForm.jsp";
		}
		//フォワード
		RequestDispatcher dis = request.getRequestDispatcher(fowardPath);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("guestName");
		String kana = request.getParameter("guestKana");
		String birthday = request.getParameter("guestBirthday");
		String pass = request.getParameter("guestPass");
		String tel = request.getParameter("guestTel");
		String mail = request.getParameter("guestMail");
		String address = request.getParameter("guestAddress");

		System.out.println(name + kana + pass + birthday + tel + mail + address);


		//登録するユーザーの情報を設定
		Guest guest = new Guest(name, kana, pass, birthday, tel, mail, address);

		RegisterGuestLogic registerGuestLogic = new RegisterGuestLogic();
		boolean isCheck = registerGuestLogic.isCheck(guest);
		System.out.println("isCheck : " + isCheck);
		if (isCheck) {
			//セッションスコープに登録ユーザーを保存
			HttpSession session = request.getSession();
			session.setAttribute("loginGuest", guest);
			//フォワード
			RequestDispatcher dis = request.getRequestDispatcher("/jsp/guest/registerGuestConfirm.jsp");
			dis.forward(request, response);
		}else {
			String errmsg = "メールアドレスが重複しています";
			//エラーメッセージをリクエストスコープに格納
			request.setAttribute("errmsg", errmsg);
			RequestDispatcher dis = request.getRequestDispatcher("/jsp/guest/registerGuestForm.jsp");
			dis.forward(request, response);
		}


	}
}
