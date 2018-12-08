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
		ShowSalesLogic ssLogic = new ShowSalesLogic();
		request.setCharacterEncoding("utf-8");
		Map<String,List<SalesInfo>> salesMap = ssLogic.execute(request.getParameter("term"));
		HttpSession session = request.getSession();
		session.setAttribute("hotelSales", salesMap.get("hotelSales"));
		session.setAttribute("areaSales", salesMap.get("areaSales"));
		session.setAttribute("totalSales", salesMap.get("totalSales"));
		RequestDispatcher dis =request.getRequestDispatcher("/jsp/sales.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
