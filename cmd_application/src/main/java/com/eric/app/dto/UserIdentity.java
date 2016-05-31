package com.eric.app.dto;

public class UserIdentity {

	int userid;
    String firstname;
    String lastname;
    String username;
    String email;
    String phonenumber;
    String password;
    
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserIdentity [userid=").append(userid).append(", firstname=").append(firstname)
				.append(", lastname=").append(lastname).append(", username=").append(username).append(", email=")
				.append(email).append(", phonenumber=").append(phonenumber).append(", password=").append(password)
				.append("]");
		return builder.toString();
	}
}
