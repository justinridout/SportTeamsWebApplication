import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.LineupDetailsHelper;
import controller.UserHelper;
import model.LineupDetails;

import model.SportTeam;
import model.User;

public class TeamsTester {

	public static void main(String[] args) {
		
		User john = new User("John");		
		LineupDetailsHelper ldh = new LineupDetailsHelper();
		SportTeam yankees = new SportTeam("Yankees", "East", 40);
		SportTeam twins = new SportTeam("Twins", "Central", 50);
		
		List<SportTeam> johnsTeams = new ArrayList<SportTeam>();
		
		johnsTeams.add(yankees);
		johnsTeams.add(twins);
		
		LineupDetails johnsLineup = new LineupDetails("Johns Lineupe", LocalDate.now(), john);
		johnsLineup.setListOfTeams(johnsTeams);
		
		ldh.insertNewLineupDetails(johnsLineup);
		
		List<LineupDetails> allLineups = ldh.getLineup();
		
		for (LineupDetails l: allLineups) {
			System.out.println(l.toString());
			
		}
		
		
	}

}
