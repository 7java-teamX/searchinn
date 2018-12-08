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

import beans.Guest;
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
		String action = request.getParameter("action");
		String path = null;
		if(action == null) {
			int id = Integer.parseInt(request.getParameter("id"));
			GuestShowLogic guestShowLogic = new GuestShowLogic();
			Guest guest = guestShowLogic.detailSearch(id);
			HttpSession ses = request.getSession();
			//1件のユーザー情報の詳細をセッションスコープに保存
			ses.setAttribute("guestDetail", guest);
			path = "/WEB-INF/jsp/admin/guestList/aGuestInfoDetail.jsp";
		} else if(action.equals("change")) {
			path = "/WEB-INF/jsp/admin/guestList/aGuestInfoChangeForm.jsp";
		}
		RequestDispatcher dis = request.getRequestDispatcher(path);
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
				String kana = request.getParameter("kana");
				String tel = request.getParameter("tel");
				String email = request.getParameter("email");
				int intGuestId = 0;
				//guestIdが nullかチェック
				if(guestId == null || guestId.equals("")) {
					guestId = "-1";
					System.out.println("in if");
				}
				intGuestId = Integer.parseInt(guestId);
				Guest guest = new Guest(intGuestId,name, kana,tel,email);

				//検索条件をセッションスコープに保存
				HttpSession ses = request.getSession();
				ses.setAttribute("criteria", guest);

				GuestShowLogic guestShowLogic = new GuestShowLogic();
				List<Guest> guestList = guestShowLogic.refineSearch(guest);
				//絞り込み検索したユーザー情報をセッションスコープに保存
				ses.setAttribute("guestList", guestList);
				RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/admin/guestList/aGuestList.jsp");
				dis.forward(request, response);

	}

}
