package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.SportTeam;

public class SportTeamHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SportsTeamsW3");
	
	public void createTeam(SportTeam sp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(sp);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<SportTeam> showAllTeams(){
		EntityManager em = emfactory.createEntityManager();
		List<SportTeam> allTeams = em.createQuery("SELECT s FROM SportTeam s").getResultList();
		return allTeams;
	}

	public void updateTeam(SportTeam toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public SportTeam searchForTeamById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		SportTeam found = em.find(SportTeam.class, idToEdit);
		em.close();
		return found;
	}

	public List<SportTeam> searchForTeamName(String name) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<SportTeam> typedQuery = em.createQuery("select st from SportTeam st where st.teamName = :selectedTeam",
				SportTeam.class);

		typedQuery.setParameter("selectedTeam", name);
		
		List<SportTeam> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public void cleanUp() {
		emfactory.close();
		
	}

	public void deleteTeam(SportTeam toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<SportTeam> typedQuery = em.createQuery("select st from SportTeam st where st.teamName = :selectedTeam and st.division = :selectedDivision and st.rosterSize = :selectedRoster",
				SportTeam.class);

		// substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedTeam", toDelete.getTeamName());
		typedQuery.setParameter("selectedDivision", toDelete.getDivision());
		typedQuery.setParameter("selectedRoster", toDelete.getRosterSize());

		// only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		SportTeam result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
}
