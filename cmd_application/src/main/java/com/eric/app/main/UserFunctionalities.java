package com.eric.app.main;

import java.util.*;

import com.eric.app.dto.UserIdentity;
import com.eric.app.jpa.services.UserRepository;
import com.eric.app.jpa.services.cmd;

import java.sql.*;


public class UserFunctionalities {

	UserRepository m = new UserRepository();

	Scanner sc = new Scanner(System.in);

	/**
	 * 
	 * @throws SQLException
	 */
	public void createUser() throws SQLException {

		UserIdentity user = new UserIdentity();
		System.out.println("Enter Firstname:");
		user.setFirstname(sc.next());

		System.out.println("Enter LastName:");
		user.setLastname(sc.next());

		System.out.println("Enter username:");
		user.setUsername(sc.next());

		System.out.println("Enter Password:");
		user.setPassword(sc.next());

		System.out.println("Enter email:");
		user.setEmail(sc.next());

		System.out.println("Enter phonenumber");
		user.setPhonenumber(sc.next());

		m.createUser(user);

	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public boolean retrieveUser() throws SQLException {

		System.out.println("Enter UserId");
		int userid = sc.nextInt();

		cmd userObj = m.retrieveUser(userid);
		if (userObj != null) {
			System.out.println("Retrived user details are :" + userObj.toString());
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @throws SQLException
	 */
	public void updateUser() throws SQLException {

		System.out.println("Enter the user id you want to update");
		int userid = sc.nextInt();

		System.out.println("Choose the user field option which you want to update from below:\n "
				+ "For First Name Type 1\n" + "For Last Name Type 2\n" + "For user name type 3\n" + "For email type 4\n"
				+ "For password type 5\n" + "For phone number type 6\n" + "For Exit Type any other number");
		int userChoice = sc.nextInt();

		if (userChoice >= 1 && userChoice <= 6) {
			System.out.println("valid choice entered. Type updated value of choosen field:");
			Map<Integer, String> userChoiceData = new HashMap<Integer, String>();
			userChoiceData.put(userChoice, sc.next());
			boolean updateSuccessful = m.updateUser(userid, userChoiceData);
			if (updateSuccessful) {
				System.out.println("user succesfully updated");
			} else {
				System.out.println("User Update failed");
			}

		} else {
			System.out.println("Wrong user input. Exiting update");
		}

	}

	/**
	 * 
	 * @throws SQLException
	 */
	public void deleteUser() throws SQLException {

		System.out.println("Enter the UserId:");
		int userid = sc.nextInt();
		m.deleteUser(userid);
	}
}
