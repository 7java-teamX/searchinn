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

import model.Reserve;
import model.ReserveShowLogic;


@WebServlet("/AReserveListServlet")
public class AReserveListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Reserve refineSearch = (Reserve)session.getAttribute("refineSearch"); //検索条件

		//検索条件存在するときDAOの実行
		if(refineSearch != null ) {
			ReserveShowLogic rSL = new ReserveShowLogic();
			List<Reserve> reserveList = rSL.excecute(refineSearch);
			session.setAttribute("reserveList", reserveList);
		}


		//main.jspのフォワードを行う
		RequestDispatcher dis =
				request.getRequestDispatcher("aReserveList.jsp");
		dis.forward(request,response);
	}

}
