package com.eric.app.main;

import java.util.*;

public class MainApp {
	public static void main(String[] args) {
		UserFunctionalities function = new UserFunctionalities();
		Scanner sc = new Scanner(System.in);
		try {

			while (true) {
				String input = sc.next();

				System.out.println(
						"Enter your choice: \nC : Create a new user \nR : Fetch existing user \nU :Update user details \nD : delete the User \nE : Exit application");
				input = sc.next();

				if (input.equalsIgnoreCase("C")) {
					function.createUser();
				}

				else if (input.equalsIgnoreCase("R")) {
					function.retrieveUser();

				}

				else if (input.equalsIgnoreCase("U")) {
					function.updateUser();
				} else if (input.equalsIgnoreCase("D")) {
					function.deleteUser();
				} else if (input.equalsIgnoreCase("E")) {

					System.out.println("Application closed");
					sc.close();
					System.exit(0);
				}

				else {
					System.out.println("Enter valid Input");

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
