package resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DateDao;
import model.Date;

/**
 * Servlet implementation class GetDatesByCalendarDateController
 */
public class GetDatesByCalendarDateController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDatesByCalendarDateController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         *
         * This data is sent to the getCustomers method in the dao.CustomerDao class
         * The data received from the getCustomers method is sent to the Customer Listing page as request attribute "customers"
         * This method redirects to the Customer Listing page
         */

		String searchKeyword = request.getParameter("calendar_date");

        DateDao dao = new DateDao();
        List<Date> dates = new ArrayList<>();
        dates = dao.getDatesByCalendar(searchKeyword);

        request.setAttribute("date", searchKeyword);
        request.setAttribute("dates", dates);
        RequestDispatcher rd = request.getRequestDispatcher("showDatesByCalendar.jsp");
        rd.forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
