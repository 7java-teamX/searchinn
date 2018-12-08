package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Admin;
import model.AdminLoginLogic;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String path = null;

		Admin admin = new Admin(id, pass);
		//ログイン処理の生成
		AdminLoginLogic adLog = new AdminLoginLogic();
		boolean isLogin = adLog.execute(admin);
		//ログイン成功時の処理
		if (isLogin) {
			//ユーザー情報をセッションスコープに保存
			HttpSession ses = request.getSession();
			ses.setAttribute("admin", admin);
			//ログイン結果を画面にフォワード
			path = "/WEB-INF/jsp/admin/admin.jsp";
		} else {
			String errMsg = "ログインできませんでした";
			request.setAttribute("errMsg", errMsg);
//ここからtest
			System.out.println("ログイン失敗");
			String errms = (String)request.getAttribute("errMsg");
			System.out.println("リクエストスコープ : " + errms);
//ここまでtest
			path = "/WEB-INF/jsp/admin/adminLogin.jsp";
		}
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}
}
