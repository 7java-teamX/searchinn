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
import dao.GuestDAO;
import model.GuestLoginLogic;

/**
 * Servlet implementation class GuestLoginServlet
 */
@WebServlet("/GuestLoginServlet")
public class GuestLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//
		String forwardPath = "";
		//リクエス	トパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String mail = request.getParameter("guestMail");
		String pass = request.getParameter("guestPass");

		System.out.println("リクエストパラメータの取得");
		System.out.println(mail);
		System.out.println(pass);

		//ログイン情報の保存
		Guest guest= new Guest(mail,pass);

		// mailとpassをもとにしてDBに接続、対象のレコードが取得できるか？
		GuestLoginLogic gLL = new GuestLoginLogic();
		boolean loginJudge = gLL.execute(guest);
		System.out.println("boolean loginJudge :"+ loginJudge);

		//true時
		if(loginJudge) {
			//メールアドレスをもとにしてDBから会員情報を取得する
			GuestDAO dao = new GuestDAO();
			Guest loginUser = dao.Allselect(guest);

			//取得した情報をsession-scopeに保存する
			HttpSession session = request.getSession();
			session.setAttribute("loginUser",loginUser);
			//フォワード処理 index.jsp
			forwardPath = "/index.jsp";
		} else {
			String errMsg = "ログインできませんでした";
			System.out.println("ログイン失敗");
			request.setAttribute("errMsg", errMsg);
			String errms = (String)request.getAttribute("errMsg");
			System.out.println("リクエストスコープ : "+errms);
			forwardPath = "/WEB-INF/jsp/guest/login_register/guestLogin.jsp";

		}

		//フォワード
		RequestDispatcher dis = request.getRequestDispatcher(forwardPath);
		dis.forward(request, response);

	}

}
