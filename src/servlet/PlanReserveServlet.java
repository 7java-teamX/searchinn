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

import model.Guest;
import model.Plan;
import model.Reserve;
import model.ReserveDateLogic;
import model.ReserveDoneLogic;
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
		switch ("action") {
		case "done":
			ReserveDoneLogic rdLogic = new ReserveDoneLogic();
			rdLogic.execute((Reserve)session.getAttribute("reserve"));
			session.removeAttribute("reserve");
			path = "/jsp/reserveDone.jsp";
			break;

		default :
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
			break;
		}

		//
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path = null;
//テスト用
		Guest loginUser = new Guest(111, "井上健太郎", "いのうえけんたろう", "1234", "1986-02-17", "08012345678", "1234@sample.com", "大阪府");
//
		Plan plan = (Plan)session.getAttribute("plan");
//本番用		Guest loginUser = (Guest)session.getAttribute("loginUser");
		int numOfAdults = Integer.parseInt(request.getParameter("numAdult"));
		int numOfChildren = Integer.parseInt(request.getParameter("numChild"));
		String checkin = request.getParameter("checkin");
		int numOfNights = Integer.parseInt(request.getParameter("nights"));
		ReserveDateLogic rdLogic = new ReserveDateLogic();
		String reserveDate = rdLogic.forDayAdd(checkin, numOfNights);
		int charge = numOfAdults * plan.getAdultCharge();
		String reserveMemo = request.getParameter("memo");



		Reserve reserve = new Reserve(numOfAdults, numOfChildren, checkin, numOfNights, reserveDate, charge
				, reserveMemo, plan.getPlanId(), plan.getPlanName(), plan.getNumRoom(), plan.getPlanImage()
				, plan.getPlanDetail(), plan.getHotelId(), plan.getHotelName(), plan.getHotelTel(), plan.getHotelAddress()
				, plan.getHotelmail(), plan.getHotelImage(), plan.getHotelDetail(), plan.getRoomTypeId(), plan.getRoomTypeName()
				, plan.getAdultCapacity(), plan.getChildCapacity(), plan.getAdultCharge(), plan.getChildCharge(), loginUser.getGuestId()
				, loginUser.getName(), loginUser.getKana(), loginUser.getPass(), loginUser.getBirthday(), loginUser.getTel()
				, loginUser.getMail(), loginUser.getAddress());
		session.setAttribute("reserve", reserve);
		path = "/jsp/reserveConfirm.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}
}
