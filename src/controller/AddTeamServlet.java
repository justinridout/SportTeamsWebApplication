package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SportTeam;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/addTeamServlet")
public class AddTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTeamServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String team = request.getParameter("team");
			String division = request.getParameter("division");
			int rosterSize = Integer.parseInt(request.getParameter("rosterSize"));
			
			SportTeam st = new SportTeam(team, division, rosterSize);

			SportTeamHelper sth = new SportTeamHelper();
			sth.createTeam(st);

		} catch (NumberFormatException e) {
			System.out.println("Please enter a whole number for roster size");
		}

		

		getServletContext().getRequestDispatcher("/index.html").forward(request, response);

	}

}
