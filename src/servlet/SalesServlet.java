package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.SalesInfo;
import model.SalesLogic;

/**
 * Servlet implementation class SalesServlet
 */
@WebServlet("/SalesServlet")
public class SalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SalesLogic ssLogic = new SalesLogic();
		request.setCharacterEncoding("utf-8");
		String term = request.getParameter("term");
		Map<String,List<SalesInfo>> salesMap = ssLogic.execute(term);

		HttpSession session = request.getSession();

		//session-scopeに格納(年-月,ホテル,エリア,合計の売上)
		session.setAttribute("term", term);
		session.setAttribute("hotelSales", salesMap.get("hotelSales"));
		session.setAttribute("areaSales", salesMap.get("areaSales"));
		session.setAttribute("totalSales", salesMap.get("totalSales"));
		RequestDispatcher dis =request.getRequestDispatcher("/WEB-INF/jsp/admin/sales/sales.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
