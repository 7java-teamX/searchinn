package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Plan;
import model.ShowCalendarLogic;

/**
 * Servlet implementation class PlanReserveServlet
 */
@WebServlet("/PlanReserveServlet")
public class PlanReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = null;
		HttpSession session = request.getSession();
		//
		ShowCalendarLogic scLogic = new ShowCalendarLogic();
		Plan plan = (Plan)session.getAttribute("plan");
		System.out.println(request.getParameter("ym"));
//		session.setAttribute("calMap", scLogic.execute(plan.getPlanId(), request.getParameter("ym")));
		//
		path = "/jsp/reserveForm.jsp";
		//
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
