package model;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="lineup_details")
public class LineupDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "LINEUP_ID")
	private int id;
	
	@Column(name="LINEUP_NAME")
	private String lineupName;
	
	@Column(name="DATE_OF_LINEUP")
	private LocalDate dateOfLineup;
	
	@ManyToOne (cascade = CascadeType.PERSIST)
	@JoinColumn(name="USER_ID")
	private User user;
	
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable
	(
		name="teams_on_lineup",
		joinColumns= { @JoinColumn(name="LINEUP_ID",
		referencedColumnName="LINEUP_ID")},
		inverseJoinColumns={ @JoinColumn(name="TEAM_ID",
		referencedColumnName="ID", unique=true)}
	)
	private List<SportTeam> listOfTeams;
	
	public LineupDetails() {
		super();
	}
	
	public LineupDetails(int id, String lineupName, LocalDate lineupDate, User user, List<SportTeam>listOfTeams) {
		this.id = id;
		this.lineupName = lineupName;
		this.dateOfLineup = lineupDate;
		this.user = user;
		this.listOfTeams = listOfTeams;
	}
	
	public LineupDetails(String lineupName, LocalDate lineupDate, User user, List<SportTeam>listOfTeams) {
		this.lineupName = lineupName;
		this.dateOfLineup = lineupDate;
		this.user = user;
		this.listOfTeams = listOfTeams;
	}
	
	public LineupDetails(String lineupName, LocalDate lineupDate, User user) {
		this.lineupName = lineupName;
		this.dateOfLineup = lineupDate;
		this.user = user;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLineupName() {
		return lineupName;
	}

	public void setLineupName(String lineupName) {
		this.lineupName = lineupName;
	}

	public LocalDate getDateOfLineup() {
		return dateOfLineup;
	}

	public void setDateOfLineup(LocalDate dateOfLineup) {
		this.dateOfLineup = dateOfLineup;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<SportTeam> getListOfTeams() {
		return listOfTeams;
	}

	public void setListOfTeams(List<SportTeam> listOfTeams) {
		this.listOfTeams = listOfTeams;
	}

	@Override
	public String toString() {
		return "LineupDetails [id=" + id + ", lineupName=" + lineupName + ", dateOfLineup=" + dateOfLineup + ", user="
				+ user + ", listOfTeams=" + listOfTeams + "]";
	}
}
