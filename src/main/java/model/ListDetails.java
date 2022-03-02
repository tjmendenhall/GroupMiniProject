package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author dynob - tjmendenhall2@dmacc.edu
 * CIS175 - Fall 2021
 * Mar 1, 2022
 */
@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate dateCreated;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private User user;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<Address> listOfAddresses;
	
	public ListDetails() {
		super();
	}
	
	/**
	 * @param id
	 * @param listName
	 * @param dateCreated
	 * @param user
	 * @param listOfAddresses
	 */
	public ListDetails(int id, String listName, LocalDate dateCreated, User user, List<Address> listOfAddresses) {
		super();
		this.id = id;
		this.listName = listName;
		this.dateCreated = dateCreated;
		this.user = user;
		this.listOfAddresses = listOfAddresses;
	}

	/**
	 * @param listName
	 * @param dateCreated
	 * @param user
	 * @param listOfAddresses
	 */
	public ListDetails(String listName, LocalDate dateCreated, User user, List<Address> listOfAddresses) {
		super();
		this.listName = listName;
		this.dateCreated = dateCreated;
		this.user = user;
		this.listOfAddresses = listOfAddresses;
	}

	/**
	 * @param listName
	 * @param dateCreated
	 * @param user
	 */
	public ListDetails(String listName, LocalDate dateCreated, User user) {
		super();
		this.listName = listName;
		this.dateCreated = dateCreated;
		this.user = user;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the listName
	 */
	public String getListName() {
		return listName;
	}
	/**
	 * @param listName the listName to set
	 */
	public void setListName(String listName) {
		this.listName = listName;
	}
	/**
	 * @return the dateCreated
	 */
	public LocalDate getDateCreated() {
		return dateCreated;
	}
	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the listOfAddresses
	 */
	public List<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	/**
	 * @param listOfAddresses the listOfAddresses to set
	 */
	public void setListOfAddresses(List<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", dateCreated=" + dateCreated + ", user=" + user
				+ ", listOfAddresses=" + listOfAddresses + "]";
	}
	
	
}
