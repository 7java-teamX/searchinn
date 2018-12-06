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

import model.RoomType;
import model.ShowFacilityLogic;

/**
 * Servlet implementation class FacilityServlet
 */
@WebServlet("/FacilityServlet")
public class FacilityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path = null;
		String action = request.getParameter("action");

		if(action == null) {
			ShowFacilityLogic sfLogic = new ShowFacilityLogic();
			Map<String,Object> facilityMap = sfLogic.execute();
			session.setAttribute("areaAll", facilityMap.get("area"));
			session.setAttribute("hotelAll", facilityMap.get("hotel"));
			session.setAttribute("planAll", facilityMap.get("plan"));
			session.setAttribute("roomTypeAll", facilityMap.get("roomType"));
			path = "/jsp/facility.jsp";

		}else {
			switch (action) {
			case "roomTypeEdit":
				int index = Integer.parseInt(request.getParameter("index"));
				List<RoomType> roomTypeAll = (List<RoomType>) session.getAttribute("roomTypeAll");
				session.setAttribute("roomType", roomTypeAll.get(index));

				path = "/jsp/roomTypeEdit.jsp";
				break;

			case "roomTypeAdd":


				path = "/jsp/roomTypeInsert.jsp";
				break;
			} //switch
		} //if else

		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
