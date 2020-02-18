package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SportTeam;

/**
 * Servlet implementation class EditTeamServlet
 */
@WebServlet("/editTeamServlet")
public class EditTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditTeamServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SportTeamHelper sth = new SportTeamHelper();
		
		try {
			String teamName = request.getParameter("teamName");
			String division = request.getParameter("division");
			int rosterSize = Integer.parseInt(request.getParameter("rosterSize"));
			Integer tempId = Integer.parseInt(request.getParameter("id"));

			SportTeam toUpdate = sth.searchForTeamById(tempId);
			toUpdate.setTeamName(teamName);
			toUpdate.setDivision(division);
			toUpdate.setRosterSize(rosterSize);
			sth.updateTeam(toUpdate);

		} catch (NumberFormatException e) {
			System.out.println("Please enter a whole number for roster size");
		}

		

		getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
	}

}
