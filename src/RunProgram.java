import java.util.List;
import java.util.Scanner;

import controller.SportTeamHelper;
import model.SportTeam;

public class RunProgram {
	
	static Scanner in = new Scanner(System.in);
	static SportTeamHelper sth = new SportTeamHelper();

	public static void main(String[] args) {

		boolean anotherRequest = true;
		while (anotherRequest){
			System.out.println("Please select a menu Item");
			System.out.println("1: Create a Team Entry");
			System.out.println("2: Edit a Team Entry");
			System.out.println("3: Delete a Team");
			System.out.println("4: View all Teams in Database");
			System.out.println("--Enter any other Number To Exit");
			int selection = in.nextInt();
			in.nextLine();
			
			if (selection == 1) {
				createTeam();
			} else if (selection == 2) {
				editTeam();
			} else if (selection == 3) {
				deleteTeam();
			} else if (selection == 4) {
				viewAllTeams();
			} else {
				sth.cleanUp();
				System.out.println("   Goodbye!   ");
				anotherRequest = false;
			}
		}
		
	}

	private static void deleteTeam() {
		System.out.print("Enter the team to delete: ");
		String team = in.nextLine();
		System.out.print("Enter the division to delete: ");
		String division = in.nextLine();
		System.out.print("Enter the roster size to delete: ");
		int roster = in.nextInt();
		
		
		SportTeam toDelete = new SportTeam(team, division, roster);
		sth.deleteTeam(toDelete);

	}

	private static void editTeam() {
		System.out.println("Enter Team Name");
		String name = in.nextLine();
		List<SportTeam> foundTeams = sth.searchForTeamName(name);
		
		if(!foundTeams.isEmpty()) {
			System.out.println("Found Team.");
			for (SportTeam t : foundTeams) {
				System.out.println(t.getId() + ": " + t.getTeamName());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();
			SportTeam toEdit = sth.searchForTeamById(idToEdit);
			System.out.println("Retrieved Team: " + toEdit.getTeamName() + " from Division " + toEdit.getDivision());
			System.out.println("1 : Update Name");
			System.out.println("2 : Update Division");
			int update = in.nextInt();
			in.nextLine();
			
			if (update == 1) {
				System.out.print("New Team Name: ");
				String newTeamName = in.nextLine();
				toEdit.setTeamName(newTeamName);
			} else if (update == 2) {
				System.out.print("New Division: ");
				String newDivision = in.nextLine();
				toEdit.setDivision(newDivision);
			}
			
			sth.updateTeam(toEdit);
		}
		else {
			System.out.println("No Teams Were Found With That Name");
		}
		
	}

	private static void viewAllTeams() {
		List<SportTeam> allTeams = sth.showAllTeams();
		for(SportTeam singleTeam: allTeams){
			System.out.println(singleTeam.teamDetails());
		}
	}

	private static void createTeam() {
		System.out.print("Enter a Team Name: ");
		String name = in.nextLine();
		System.out.print("Enter the Teams Division: ");
		String division = in.nextLine();
		System.out.print("Enter the roster size: ");
		int roster = in.nextInt();
		
		SportTeam toAdd = new SportTeam(name, division, roster);
		sth.createTeam(toAdd);
	}

	
	

}
