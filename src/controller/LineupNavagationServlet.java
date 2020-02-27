package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LineupDetails;
import model.SportTeam;

/**
 * Servlet implementation class LineupNavagationServlet
 */
@WebServlet("/lineupNavagationServlet")
public class LineupNavagationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LineupNavagationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SportTeamHelper sth = new SportTeamHelper();
		LineupDetailsHelper ldh = new LineupDetailsHelper();
		
		String action = request.getParameter("doThisToLineup");
		String path = "/viewAllLineupsServlet";
		
		if(action.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				LineupDetails toDelete = ldh.searchForLineupById(tempId);
				ldh.deleteLineup(toDelete);
			}catch(NumberFormatException e) {
				System.out.println("Please select a Lineup");
			}
			
		}
		else if(action.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				LineupDetails toEdit = ldh.searchForLineupById(tempId);
				request.setAttribute("toEdit", toEdit);
				path = "/edit-lineup.jsp";
				
				request.setAttribute("allTeams", sth.showAllTeams());
				if(sth.showAllTeams().isEmpty()) {
					request.setAttribute("allTeams", " ");
				}
			}catch(NumberFormatException e) {
				System.out.println("Please select an item");
			}
		}
		else if (action.equals("add")) {
			path = "/new-team.jsp";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
