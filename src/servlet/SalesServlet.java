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

import model.SalesInfo;
import model.ShowSalesLogic;

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
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		ShowSalesLogic ssLogic = new ShowSalesLogic();
		//
		String term = request.getParameter("term");
		Map<String,List<SalesInfo>> salesMap = ssLogic.execute(term);
		String ym[] = term.split("-");
		//
		session.setAttribute("year", ym[0]);
		session.setAttribute("month", ym[1]);
		//
		session.setAttribute("hotelSales", salesMap.get("hotelSales"));
		session.setAttribute("areaSales", salesMap.get("areaSales"));
		session.setAttribute("totalSales", salesMap.get("totalSales"));
		//
		RequestDispatcher dis =request.getRequestDispatcher("/jsp/sales.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
