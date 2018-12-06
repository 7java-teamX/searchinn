package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RoomType;
import model.RoomTypeLogic;

/**
 * Servlet implementation class RoomTypeServlet
 */
@WebServlet("/RoomTypeServlet")
public class RoomTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		String path = null;
		RoomType roomType = (RoomType) session.getAttribute("roomType");
		RoomTypeLogic rtLogic = new RoomTypeLogic();

		switch (action) {
		case "editDone":
			rtLogic.update(roomType);

			path = "/jsp/done.jsp";
//			path = "/FacilityServlet";
			break;

		case "insertDone":
			rtLogic.insert(roomType);

			path = "/jsp/done.jsp";
//			path = "/FacilityServlet";
			break;
		default:
			break;
		}
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		RoomType roomType = null;
		String path =null;

		String roomTypeName = request.getParameter("roomTypeName");
		int adultCapacity = Integer.parseInt(request.getParameter("adultCapacity"));
		int childCapacity = Integer.parseInt(request.getParameter("childCapacity"));
		int adultCharge = Integer.parseInt(request.getParameter("adultCharge"));
		int childCharge = Integer.parseInt(request.getParameter("childCharge"));

		switch (action) {
		case "editConfirm":
			int roomTypeId =  Integer.parseInt(request.getParameter("roomTypeId"));
			roomType = new RoomType(roomTypeId, roomTypeName, adultCapacity, childCapacity, adultCharge, childCharge);
			path = "/jsp/roomTypeEditConfirm.jsp";
			break;

		case "insertConfirm":
			roomType = new RoomType(roomTypeName, adultCapacity, childCapacity, adultCharge, childCharge);
			path = "/jsp/roomTypeInsertConfirm.jsp";
			break;
		}
		session.setAttribute("roomType", roomType);

		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}

}
