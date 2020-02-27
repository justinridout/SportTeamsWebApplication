package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.LineupDetails;

public class LineupDetailsHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SportsTeamsW3");
	
	public void insertNewLineupDetails(LineupDetails l) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<LineupDetails> getLineup(){
		EntityManager em = emfactory.createEntityManager();
		List<LineupDetails> allLineups = em.createQuery("SELECT l FROM LineupDetails l").getResultList();
		return allLineups;
	}
	
	public void deleteLineup(LineupDetails toDelete) {
		
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<LineupDetails> typedQuery = em.createQuery("select ld from LineupDetails ld where LINEUP_ID = : selectedId",
				LineupDetails.class);
		
		typedQuery.setParameter("selectedId", toDelete.getId());
		
		typedQuery.setMaxResults(1);
		
		LineupDetails result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public LineupDetails searchForLineupById(int tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		LineupDetails found = em.find(LineupDetails.class, tempId);
		System.out.println(found);
		em.close();
		return found;
	}

	public void updateLineup(LineupDetails toUpdate) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toUpdate);
		em.getTransaction().commit();
		em.close();
		
	}
}
