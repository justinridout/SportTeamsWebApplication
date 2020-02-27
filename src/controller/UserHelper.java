package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.LineupDetails;
import model.User;

public class UserHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SportsTeamsW3");
	
	public void inserUser(User u) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<User> showAllUsers(){
		EntityManager em = emfactory.createEntityManager();
		List<User> allUsers = em.createQuery("SELECT u FROM User u").getResultList();
		return allUsers;
	}
	public void updateUser(User toUpdate) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toUpdate);
		em.getTransaction().commit();
		em.close();
	}
	
	public User searchForUserById(int tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		User found = em.find(User.class, tempId);
		System.out.println(found);
		em.close();
		return found;
	}
}
