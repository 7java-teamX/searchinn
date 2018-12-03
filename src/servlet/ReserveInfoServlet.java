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

import model.Reserve;

@WebServlet("/ReserveInfoServlet")
public class ReserveInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String day = request.getParameter("day");
		String hotelName = request.getParameter("hotelName");
		String planName = request.getParameter("planName");
		String guestName = request.getParameter("guestName");
		String StrIndex = request.getParameter("index");

		//検索条件をインスタンスに格納
		Reserve refineSearch = new Reserve(day,hotelName,planName,guestName);

		if(StrIndex !=null) {
			int index = Integer.parseInt(StrIndex);
			HttpSession session = request.getSession();
			//キャスト必要?? 後日チェック
			@SuppressWarnings("unchecked")
			List<Reserve> reserveList = (List<Reserve>)session.getAttribute("reserveList");
			Reserve reserveInfo = new Reserve();
			reserveInfo = reserveList.get(index);
			session.setAttribute("reserveInfo",reserveInfo);
			//aReserveList.jspのフォワード処理
			RequestDispatcher dis = request.getRequestDispatcher("aReserveDetail.jsp");
			dis.forward(request,response);
		}

		//セッションスコープに格納
		HttpSession session = request.getSession();
		session.setAttribute("refineSearch", refineSearch);

		//aReserveList.jspのフォワード処理
		RequestDispatcher dis = request.getRequestDispatcher("/AReserveListServlet");
		dis.forward(request,response);


	}

}
