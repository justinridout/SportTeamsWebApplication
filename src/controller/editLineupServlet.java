package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LineupDetails;
import model.SportTeam;
import model.User;

/**
 * Servlet implementation class editLineupServlet
 */
@WebServlet("/editLineupServlet")
public class editLineupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editLineupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SportTeamHelper sth = new SportTeamHelper();
		LineupDetailsHelper ldh = new LineupDetailsHelper();
		
		String lineupName = request.getParameter("teamName");
		System.out.println("Team Name: " + lineupName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String userName = request.getParameter("userName");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
					
		}catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		String[] selectedTeams = request.getParameterValues("allTeamsToAdd");
		List<SportTeam> selectedTeamsInLineup = new ArrayList<SportTeam>();
		
		if(selectedTeams != null && selectedTeams.length > 0) {
			for (int i = 0; i<selectedTeams.length; i++) {
				System.out.println(selectedTeams[i]);
				SportTeam c = sth.searchForTeamById(Integer.parseInt(selectedTeams[i]));
				selectedTeamsInLineup.add(c);
			}
		}
		
		try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Integer userId = Integer.parseInt(request.getParameter("userId"));
			UserHelper uh = new UserHelper();
			User uToUpdate = uh.searchForUserById(userId);
			LineupDetails toUpdate = ldh.searchForLineupById(tempId);
			
			uToUpdate.setUserName(userName);
			uh.updateUser(uToUpdate);
			toUpdate.setLineupName(lineupName);
			toUpdate.setDateOfLineup(ld);
			toUpdate.setListOfTeams(selectedTeamsInLineup);
			
			uh.updateUser(uToUpdate);
			ldh.updateLineup(toUpdate);
			
		}catch (NumberFormatException e) {
			System.out.println(" IDK ");
		}
		
		getServletContext().getRequestDispatcher("/viewAllLineupsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
