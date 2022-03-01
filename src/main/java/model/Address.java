package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dynob - tjmendenhall2@dmacc.edu CIS175 - Fall 2021 Feb 24, 2022
 */
@Entity
@Table(name = "addresses")
public class Address {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	@Column(name = "OWNER")
	private String owner;
	@Column(name = "BUILDNUM")
	private String buildingNum;
	@Column(name = "APTNUM")
	private String aptNum;
	@Column(name = "STREET")
	private String streetName;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATE")
	private String state;
	@Column(name = "ZIP")
	private String zip;

	public Address() {
		super();
	}

	/**
	 * @param id
	 * @param owner
	 * @param buildingNum
	 * @param aptNum
	 * @param streetName
	 * @param city
	 * @param state
	 * @param zip
	 */
	public Address(int id, String owner, String buildingNum, String aptNum, String streetName, String city,
			String state, String zip) {
		super();
		this.id = id;
		this.owner = owner;
		this.buildingNum = buildingNum;
		this.aptNum = aptNum;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	

	/**
	 * @param id
	 * @param owner
	 * @param buildingNum
	 * @param streetName
	 * @param city
	 * @param state
	 * @param zip
	 */
	public Address(int id, String owner, String buildingNum, String streetName, String city, String state,
			String zip) {
		super();
		this.id = id;
		this.owner = owner;
		this.buildingNum = buildingNum;
		this.aptNum = "None";
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	

	/**
	 * @param owner
	 * @param buildingNum
	 * @param aptNum
	 * @param streetName
	 * @param city
	 * @param state
	 * @param zip
	 */
	public Address(String owner, String buildingNum, String aptNum, String streetName, String city, String state,
			String zip) {
		super();
		this.owner = owner;
		this.buildingNum = buildingNum;
		this.aptNum = aptNum;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	/**
	 * @param owner
	 * @param buildingNum
	 * @param streetName
	 * @param city
	 * @param state
	 * @param zip
	 */
	public Address(String owner, String buildingNum, String streetName, String city, String state, String zip) {
		super();
		this.owner = owner;
		this.buildingNum = buildingNum;
		this.aptNum = "None";
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zip = zip;
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
	 * @return the addressOwner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param addressOwner the addressOwner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the buildingNum
	 */
	public String getBuildingNum() {
		return buildingNum;
	}

	/**
	 * @param buildingNum the buildingNum to set
	 */
	public void setBuildingNum(String buildingNum) {
		this.buildingNum = buildingNum;
	}

	/**
	 * @return the aptNum
	 */
	public String getAptNum() {
		return aptNum;
	}

	/**
	 * @param aptNum the aptNum to set
	 */
	public void setAptNum(String aptNum) {
		if (aptNum == null) {
			this.aptNum = "None";
		} else {
			this.aptNum = aptNum;
		}
	}

	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * @param streetName the streetName to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", addressOwner=" + owner + ", buildingNum=" + buildingNum + ", aptNum="
				+ aptNum + ", streetName=" + streetName + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}

	public String returnAddressDetails() {
		return "Owner of Address: " + this.owner + "\nBuilding Number: " + this.buildingNum
				+ "\nApartment Number: " + this.aptNum + "\nStreet Name: " + this.streetName + "\nCity: " + this.city
				+ "\nState: " + this.state + "\nZip: " + this.zip;
	}

	public String returnAddressDetailsNoApt() {
		return "Owner of Address: " + this.owner + "\nBuilding Number: " + this.buildingNum + "\nStreet Name: "
				+ this.streetName + "\nCity: " + this.city + "\nState: " + this.state + "\nZip: " + this.zip;
	}

}
