package com.eric.app.jpa.services;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.Table;

@Entity
public class cmd {
	@Id
	@GeneratedValue
	private int userid;
	private String firstname;
	private String lastname;
	private String username;
	private String email;
	private String phonennumber;
	private String password;

	/**
	 * @return the id
	 */
	public int getUserId() {
		return userid;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public cmd setUserId(int userid) {
		this.userid = userid;
		return this;
	}

	/**
	 * @return the street
	 */
	public String getFirstName() {
		return firstname;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public cmd setFirstName(String firstname) {
		this.firstname = firstname;
		return this;
	}

	/**
	 * @return the city
	 */
	public String getLastName() {
		return lastname;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public cmd setLastName(String lastname) {
		this.lastname = lastname;
		return this;
	}

	/**
	 * @return the province
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param province
	 *            the province to set
	 */
	public cmd setUsername(String username) {
		this.username = username;
		return this;
	}

	/**
	 * @return the country
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public cmd setEmail(String email) {
		this.email = email;
		return this;
	}

	/**
	 * @return the postcode
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param postcode
	 *            the postcode to set
	 */
	public cmd setPassword(String password) {
		this.password = password;
		return this;
	}


	public String getPhonennumber() {
		return phonennumber;
	}

	public void setPhonennumber(String phonennumber) {
		this.phonennumber = phonennumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("cmd [UserId=").append(userid).append(", FirstName=").append(firstname).append(", LastName=")
				.append(lastname).append(", username=").append(username).append(", email=").append(email)
				.append(", phonennumber=").append(phonennumber).append(", password=").append(password).append("]");
		return builder.toString();
	}

	

}
