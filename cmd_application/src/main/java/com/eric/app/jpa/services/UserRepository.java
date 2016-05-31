package com.eric.app.jpa.services;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.eric.app.dto.UserIdentity;

import java.util.*;

public class UserRepository {
	EntityManager em = ParsistenceManager.INSTANCE.getEntityManager();

	public void createUser(UserIdentity user) {
		cmd table_input = new cmd();
		table_input.setFirstName(user.getFirstname()).setLastName(user.getLastname()).setUsername(user.getUsername())
				.setEmail(user.getEmail()).setPassword(user.getPassword()).setPhonennumber(user.getPhonenumber());

		em.getTransaction().begin();
		em.persist(table_input);
		em.getTransaction().commit();
		em.close();
		ParsistenceManager.INSTANCE.close();
	}

	@SuppressWarnings("unchecked")
	public cmd retrieveUser(int userId) {

		Query query = em.createQuery("SELECT c FROM cmd c where c.UserId=:userid");
		query.setParameter("userid", userId);
		List<cmd> list = query.getResultList();

		if (list != null && list.size() > 0) {
			System.out.println("User exists for user id" + userId);
			return list.get(0);
		} else {
			System.out.println("No user exists for user id=" + userId);
			return null;
		}
	}

	public boolean updateUser(int userId, Map<Integer, String> userChoiceData) {

		try {
			cmd existingUserData = em.find(cmd.class, userId);
			if (existingUserData == null) {
				System.out.println("No user with userId = " + userId + " exists in DB. DB update failed");
				return false;
			}

			if (userChoiceData == null || userChoiceData.size() == 0) {
				System.out.println("No new user data entered for update");
				return false;
			}

			em.getTransaction().begin();

			int userChoice = 0;
			String updateUserData = "";

			for (Map.Entry<Integer, String> entry : userChoiceData.entrySet()) {
				System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
				userChoice = entry.getKey();
				updateUserData = entry.getValue();
			}

			switch (userChoice) {
			case 1:
				existingUserData.setFirstName(updateUserData);
				break;

			case 2:
				existingUserData.setLastName(updateUserData);
				break;

			case 3:
				existingUserData.setUsername(updateUserData);
				break;

			case 4:
				existingUserData.setEmail(updateUserData);
				break;

			case 5:
				existingUserData.setPassword(updateUserData);
				break;

			case 6:
				existingUserData.setPhonennumber(updateUserData);
				break;

			default:
				System.out.println("Invalid choice for user update data");
				return false;
			}

			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out
					.println("Got exception while updating user data. Detailed error message is ==>>" + e.getMessage());
			return false;
		}

	}

	public void deleteUser(int UserId) {

		int userid = UserId;
		cmd table_input = em.find(cmd.class, userid);
		em.getTransaction().begin();
		em.remove(table_input);
		em.getTransaction().commit();
	}

}