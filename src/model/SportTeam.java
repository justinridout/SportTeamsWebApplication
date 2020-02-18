package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="teams")
public class SportTeam {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name="TEAM")
	private String teamName;
	@Column(name="DIVISION")
	private String division;
	@Column(name="ROSTERSIZE")
	private int rosterSize;
	
	public SportTeam() {
		super();
	}
	
	public SportTeam(String name, String div, int roster) {
		super();
		this.teamName = name;
		this.division = div;
		this.rosterSize = roster;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public int getRosterSize() {
		return rosterSize;
	}

	public void setRosterSize(int rosterSize) {
		this.rosterSize = rosterSize;
	}
	
	public String teamDetails() {
		return teamName + ", Division: " + division + ", Roster Size: " + rosterSize;
	}
	
}
