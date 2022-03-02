package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dynob - tjmendenhall2@dmacc.edu
 * CIS175 - Fall 2021
 * Mar 1, 2022
 */
@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue
	private int id;
	private String userName;
	
	public User() {
		super();
	}

	/**
	 * @param id
	 * @param userName
	 */
	public User(int id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}

	/**
	 * @param userName
	 */
	public User(String userName) {
		super();
		this.userName = userName;
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + "]";
	}
	
	public String returnUserDetails() {
		return "ID: " + this.id + "\nName: " + this.userName;
	}
	
}
