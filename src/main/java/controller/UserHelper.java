package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.User;

/**
 * @author dynob - tjmendenhall2@dmacc.edu
 * CIS175 - Fall 2021
 * Mar 1, 2022
 */
public class UserHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GroupMiniProject");

	public void insertUser(User u) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		em.close();
	}

	public List<User> showAllUsers() {
		EntityManager em = emfactory.createEntityManager();
		List<User> allUsers = em.createQuery("SELECT u FROM User u").getResultList();
		return allUsers;
		}
	
	public User findUser(String nameToLookUp) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<User> typedQuery = em.createQuery("select u from User u where u.userName = :selectedName", User.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		User foundUser;
		try {
			foundUser = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundUser = new User(nameToLookUp);
		}
		em.close();

		return foundUser;
	}
}
