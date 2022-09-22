package com.lti.app;

import java.util.Scanner;
import com.lti.bean.User;
import com.lti.exception.IncorrectPasswordException;
import com.lti.exception.UserNotFoundException;
import com.lti.service.UserService;

public class CRSMenuApplication {

	
	public static void main(String[] args) {

		String username = "";
		String password = "";
		UserService userService = new UserService();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("******************Welcome to the CRS Application*************");
		
		// Main menu selection loop
		while(true) {
			
			System.out.println("\nEnter selection: ");
			System.out.println("1. Login");
			System.out.println("2. Student Registration");
			System.out.println("3. Update Password");
			System.out.println("4. Exit");
			System.out.print("\n-> ");
			
			String selection = scan.nextLine();
			if(selection == "" || selection == null || selection.equals(null)) {
				selection = scan.nextLine();
			}
			
			Boolean exit = false;
			
			// input clean-up
			selection = selection.toLowerCase().replace(" ", "");
			switch(selection) {
				case "1": 
					selection = "login"; 
					break;
				case "2": 
					selection = "student registration"; 
					break;
				case "3": 
					selection = "update password"; 
					break;
				case "4": 
					selection = "exit"; 
					break;
				default: break;
			}
			
			switch(selection.toLowerCase().replace(" ", "")) {
				case "login":
					
					System.out.print("\nEnter Username: ");
					username = scan.next();
					
					System.out.print("Enter Password: ");
					password = scan.next();		
					
					// validate login
					User user;
					try {
						user = userService.Login(username, password);
					} catch (UserNotFoundException e) {
						e.getMessage();
						e.printStackTrace();
						break;
					} catch (IncorrectPasswordException e) {
						e.getMessage();
						e.printStackTrace();
						break;
					} 
					
					// menus
					CRSStudentMenu studentMenu = new CRSStudentMenu(scan, user);
					CRSProfessorMenu professorMenu = new CRSProfessorMenu(scan, user);
					CRSAdminMenu adminMenu = new CRSAdminMenu(scan, username);
					
					// TODO: login credential validation method here						
					
					// Role Selection Loop
					while(true) {
					
						System.out.println("\nEnter Role: ");
						System.out.println("1. Student");
						System.out.println("2. Professor");
						System.out.println("3. Admin");
						System.out.println("4. Back");
						System.out.print("\n-> ");
						String role = scan.next();
						
						role = role.toLowerCase().replace(" ", "");
						switch(role) {
							case "1": 
								role = "student";
								break;
							case "2": 
								role = "professor";
								break;
							case "3": 
								role = "admin";
								break;
							case "4": 
								role = "back";
								break;
						}
						
						Boolean role_back = false;
						switch(role.toLowerCase()) {
							case "student": 								
								System.out.println("\nWelcome Student " + "(" + username.toUpperCase() + ")");
								studentMenu.menu();
								break;			
							case "professor": 
								System.out.println("\nWelcome Professor " + "(" + username.toUpperCase() + ")");
								professorMenu.menu();
								break;		
							case "admin": 
								System.out.println("\nWelcome Admin" + "(" + username.toUpperCase() + ")");
								adminMenu.menu();
								break;					
							case "back":
								role_back = true;
								break;
							default:
								System.out.println("Please make another selection, role not found\n");
								continue;
						}
						if(role_back) break;  // exit out of role while loop
					}	
					break;  	// login switch case
				case "student registration": 
					System.out.println("Student Registration...");
					break;
				case "update password": 
					System.out.println("Updating Password...");
					break;
				case "exit": 
					exit = true;
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Please make another selection, option not found\n");
					continue;
			}
			
			if(exit) break;    // exit out of main menu loop
		}
		
		userService.Logout(username);
		System.out.println("\nEnd of program");	
	}
}
