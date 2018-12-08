package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Plan;
import model.PlanEditLogic;

/**
 * Servlet implementation class PlanEditServlet
 */
@WebServlet("/PlanEditServlet")
public class PlanEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		String path = null;
		Plan plan = (Plan) session.getAttribute("plan");
		PlanEditLogic peLogic = new PlanEditLogic();

		switch (action) {
		case "editDone":
			peLogic.update(plan);

//			path = "/jsp/done.jsp";
			path = "/FacilityServlet";
			break;

		case "insertDone":
			//未実装
			break;
		default:
			break;
		}
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String action = request.getParameter("action");

		String planName = request.getParameter("planName");
		int hotelId = Integer.parseInt(request.getParameter("hotelId"));
		int roomTypeId = Integer.parseInt(request.getParameter("roomTypeId"));
		int numRoom = Integer.parseInt(request.getParameter("numRoom"));
		String planImage = request.getParameter("planImage");
		String planDetail = request.getParameter("planDetail");
		Plan plan = null;
		String path = null;


		switch (action) {
		case "editConfirm":
			int planId = Integer.parseInt(request.getParameter("planId"));

			plan = new Plan(planId, planName, hotelId, roomTypeId, numRoom, planImage, planDetail);
			path = "/WEB-INF/jsp//admin/facility/planEditConfirm.jsp";
			break;

		case "insertConfirm":
			//未実装
			break;
		}

		session.setAttribute("plan", plan);

		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);

	}

}
