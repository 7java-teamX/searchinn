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

import beans.Plan;
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
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = null;
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		//
		switch (request.getParameter("action")) {
		case "toPlan":
			//hotelIDを取得，HotelSelectLogicからDAOを実行し，planListをセッションスコープにセット，フォワード先を設定
			HotelSelectLogic hsLogic = new HotelSelectLogic();
			session.setAttribute("planList", hsLogic.execute(request.getParameter("hotelId")));
			path = "/WEB-INF/jsp/guest/reserve/plan.jsp";
			break;
		case "toReserve":
			//planListとindexを取得，該当のplanをセッションスコープに保存，フォワード先を設定
			List<Plan> planList = (List<Plan>)session.getAttribute("planList");
			System.out.println("planList index:" + request.getParameter("index"));
			System.out.println(planList.get(Integer.parseInt(request.getParameter("index"))));
			session.setAttribute("plan", planList.get(Integer.parseInt(request.getParameter("index"))));
			path = "/PlanReserveServlet";
			break;
		}
		//フォワード
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
