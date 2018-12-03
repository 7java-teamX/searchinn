package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Guest;
import model.GuestShowLogic;


/**
 * Servlet implementation class GuestInfoServlet
 */
/**
 * @author 3BC1_12
 *
 */
@WebServlet("/GuestInfoServlet")
public class GuestInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		GuestShowLogic guestShowLogic = new GuestShowLogic();
		Guest guest = guestShowLogic.detailSearch(id);
		HttpSession ses = request.getSession();
		//1件のユーザー情報の詳細をセッションスコープに保存
		ses.setAttribute("guestDetail", guest);
		RequestDispatcher dis = request.getRequestDispatcher("/aGuestInfoDetail.jsp");
		dis.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメーターの取得
				request.setCharacterEncoding("UTF-8");
				String  guestId = request.getParameter("id");
				String name = request.getParameter("name");
				String tel = request.getParameter("tel");
				String email = request.getParameter("email");
				//guestIdが nullかチェック
				if(guestId == null || guestId == "") {
					guestId = "-1";
				}
				int IntGuestId = Integer.parseInt(guestId);
				Guest guest = new Guest(IntGuestId, name,tel,email);

				//検索条件をセッションスコープに保存
				HttpSession ses = request.getSession();
				ses.setAttribute("criteria", guest);

				GuestShowLogic guestShowLogic = new GuestShowLogic();
				List<Guest> guestList = guestShowLogic.refineSearch(guest);
				//絞り込み検索したユーザー情報をセッションスコープに保存
				ses.setAttribute("guestList", guestList);
				RequestDispatcher dis = request.getRequestDispatcher("/aGuestList.jsp");
				dis.forward(request, response);

	}

}
