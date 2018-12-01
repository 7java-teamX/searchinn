package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HotelSelectLogic;

/**
 * Servlet implementation class PlanSelectServlet
 */
@WebServlet("/PlanSelectServlet")
public class PlanSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//hotelIDを取得，HotelSelectLogicからDAOを実行し，planListをセッションスコープにセット
		request.setCharacterEncoding("utf-8");
		HotelSelectLogic hsLogic = new HotelSelectLogic();
		HttpSession session = request.getSession();
		session.setAttribute("planList", hsLogic.execute(request.getParameter("hotelId")));
		//フォワード
		RequestDispatcher dis = request.getRequestDispatcher("/jsp/plan.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
