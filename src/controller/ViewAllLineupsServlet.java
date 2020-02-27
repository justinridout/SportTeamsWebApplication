package controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LineupDetails;

/**
 * Servlet implementation class ViewAllLineupsServlet
 */
@WebServlet("/viewAllLineupsServlet")
public class ViewAllLineupsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllLineupsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LineupDetailsHelper ldh = new LineupDetailsHelper();
		
		List<LineupDetails> ld = ldh.getLineup();
		
		request.setAttribute("allLineups", ld);
		
		if(ld.isEmpty()) {
			request.setAttribute("allLineups", " ");
		}
		
		getServletContext().getRequestDispatcher("/team-lineup-by-user.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
