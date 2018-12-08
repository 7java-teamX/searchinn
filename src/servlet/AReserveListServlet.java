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

import beans.Reserve;
import model.ReserveShowLogic;

@WebServlet("/AReserveListServlet")
public class AReserveListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		System.out.println(action);
		HttpSession session = request.getSession();
		Reserve refineSearch = (Reserve) session.getAttribute("refineSearch");

		if (action == null) {
			 if (refineSearch != null) { //検索条件存在する時DAOの実行
					ReserveShowLogic rSL = new ReserveShowLogic();
					List<Reserve> reserveList = rSL.excecute(refineSearch);
					session.setAttribute("reserveList", reserveList);
			}
		} else if(action.equals("delete")) {
			session.removeAttribute("refineSearch");
		}
		//main.jspのフォワードを行う
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/admin/reserveList/aReserveList.jsp");
		dis.forward(request, response);
	}

}