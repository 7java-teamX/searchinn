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

import beans.Guest;
import beans.Plan;
import beans.Reserve;
import model.MakeDay;
import model.ReserveCheck;
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
		String action = request.getParameter("action");
		System.out.println(action);
		String path = null;
		if(action == null || action.equals("toReserve")) {
			//予約状況・入力フォームの表示
			System.out.println("予約画面表示");
			String ym = request.getParameter("ym");
			//初回・年月未選択時は現在の月に設定
			if(ym == null || ym.equals("")){
				Calendar cal = Calendar.getInstance();
				ym = new SimpleDateFormat("yyyy-MM").format(cal.getTime());
			}
			//前ページで選択されたプランの情報を取得，選択年月の予約状況カレンダーを生成，年月・カレンダーをMapとしてセッションスコープにセット
			ShowCalendarLogic scLogic = new ShowCalendarLogic();
			Plan plan = (Plan)session.getAttribute("plan");
			session.setAttribute("calMap", scLogic.execute(plan.getPlanId(),ym));

			//今日の日付 3か月後の日付を取得しスコープに格納(予約可能日の制限用)
			MakeDay make = new MakeDay();
			String today = make.makeToday();
			String afterDay = make.make3Month();
			session.setAttribute("today",today );
			session.setAttribute("afterDay",afterDay );
			//フォワード先の設定
			path = "/WEB-INF/jsp/guest/reserve/reserveForm.jsp";
		//予約確認→確定
		} else if(action.equals("done")) {
			ReserveDoneLogic rdLogic = new ReserveDoneLogic();
			rdLogic.execute((Reserve)session.getAttribute("reserve"));
			System.out.println("予約実行");
			session.removeAttribute("reserve");
			path = "/WEB-INF/jsp/guest/reserve/reserveDone.jsp";
		}//if elseif

		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String path = null;
		//プラン情報
		Plan plan = (Plan)session.getAttribute("plan");
		//ゲスト情報　テスト用
		//Guest loginUser = new Guest(111, "井上健太郎", "いのうえけんたろう", "1234", "1986-02-17", "08012345678", "1234@sample.com", "大阪府");
		//ゲスト情報　本番用
		Guest loginUser = (Guest)session.getAttribute("loginUser");
		//入力内容取得と日程・料金の計算
		int numOfAdults = Integer.parseInt(request.getParameter("numAdult"));
		int numOfChildren = Integer.parseInt(request.getParameter("numChild"));
		String checkin = request.getParameter("checkin");
		int numOfNights = Integer.parseInt(request.getParameter("nights"));
		ReserveDateLogic rdLogic = new ReserveDateLogic();
		String reserveDate = rdLogic.forDayAdd(checkin, numOfNights);
		int charge = numOfAdults * plan.getAdultCharge();
		String reserveMemo = request.getParameter("memo");
		//planIdの呼び出し
		int planId  = plan.getPlanId();

		//ログイン状態の確認
		if(loginUser != null) {
			System.out.println("ログイン済み");
			//予約期間内の部屋数が問題ないかを確認処理
			//return:boolean   true時はreserveConfirm.jspにフォワード処理，false時はreserveForm.jspにフォワード処理
			ReserveCheck rc = new ReserveCheck();
			boolean bool = rc.checkReserve(planId, checkin, numOfNights);
			if(bool) {
				Reserve reserve = new Reserve(numOfAdults, numOfChildren, checkin, numOfNights, reserveDate, charge
						, reserveMemo, plan.getPlanId(), plan.getPlanName(), plan.getNumRoom(), plan.getPlanImage()
						, plan.getPlanDetail(), plan.getHotelId(), plan.getHotelName(), plan.getHotelTel(), plan.getHotelAddress()
						, plan.getHotelmail(), plan.getHotelImage(), plan.getHotelDetail(), plan.getRoomTypeId(), plan.getRoomTypeName()
						, plan.getAdultCapacity(), plan.getChildCapacity(), plan.getAdultCharge(), plan.getChildCharge(), loginUser.getGuestId()
						, loginUser.getName(), loginUser.getKana(), loginUser.getPass(), loginUser.getBirthday(), loginUser.getTel()
						, loginUser.getMail(), loginUser.getAddress());
				session.setAttribute("reserve", reserve);
				System.out.println("空室あり");
				path = "/WEB-INF/jsp/guest/reserve/reserveConfirm.jsp";
			} else if(!bool) {
				request.setAttribute("errMsg", "空き室が超過しているので予約できません");
				path = "/WEB-INF/jsp/guest/reserve/reserveForm.jsp";
			}
		} else {
			System.out.println("未ログイン");
			path = "/WEB-INF/jsp/guest/login_register/guestLogin.jsp";
		}

		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}
}
