package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Address;



/**
 * @author dynob - tjmendenhall2@dmacc.edu
 * CIS175 - Fall 2021
 * Feb 24, 2022
 */
public class AddressHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GroupMiniProject");

	public void insertAddress(Address a) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();

	}

	public List<Address> showAllAddresses() {
		EntityManager em = emfactory.createEntityManager();
		List<Address> allAddresses = em.createQuery("SELECT a from Address a").getResultList();
		return allAddresses;

	}

	public void deleteAddress(Address toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Address> typedQuery = em.createQuery("select a from Address a where a.id = :selectedId and a.owner = :selectedOwner", Address.class);

		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setParameter("selectedOwner", toDelete.getOwner());

		typedQuery.setMaxResults(1);

		Address result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Address searchForAddressById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		Address found = em.find(Address.class, idToEdit);
		em.close();
		return found;
	}

	public void updateAddress(Address toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	

	public List<Address> searchForAddressByOwner(String owner) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Address> typedQuery = em.createQuery("select a from Address a where a.owner = :selectedOwner", Address.class);

		typedQuery.setParameter("selectedOwner", owner);

		List<Address> foundAddresses = typedQuery.getResultList();
		em.close();
		return foundAddresses;
	}

	public List<Address> searchForAddressByCity(String city) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Address> typedQuery = em.createQuery("select a from Address a where a.city = :selectedCity", Address.class);

		typedQuery.setParameter("selectedCity", city);

		List<Address> foundAddresses = typedQuery.getResultList();
		em.close();
		return foundAddresses;
	}

	public void cleanUp() {
		emfactory.close();
	}
}
