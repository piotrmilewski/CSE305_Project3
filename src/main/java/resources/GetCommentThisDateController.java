package resources;

import dao.DateDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class GetEmployeesController
 */
public class GetCommentThisDateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCommentThisDateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String user1ID = request.getParameter("user1ID");
		String user2ID = request.getParameter("user2ID");
		String date = request.getParameter("date");
		String comment = request.getParameter("comment");

		DateDao dao = new DateDao();
		String result = dao.commentDate(user1ID, user2ID, date, comment);

		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("confirmMessage.jsp");
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
