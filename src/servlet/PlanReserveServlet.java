package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String path = null;
		String ym = request.getParameter("ym");
		if(ym == null || ym.equals("")){
			Calendar cal = Calendar.getInstance();
			ym = new SimpleDateFormat("yyyy-MM").format(cal.getTime());
		}
		//
		ShowCalendarLogic scLogic = new ShowCalendarLogic();
		Plan plan = (Plan)session.getAttribute("plan");
		session.setAttribute("calMap", scLogic.execute(plan.getPlanId(),ym));
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

	}

}
