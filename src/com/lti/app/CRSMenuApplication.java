package com.lti.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lti.bean.Course;
import com.lti.bean.Student;
import com.lti.bean.User;
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
			
			Boolean exit = false;
			
			switch(selection.toLowerCase()) {
				case "login":
					
					System.out.print("\nEnter Username: ");
					username = scan.next();
					
					System.out.print("Enter Password: ");
					password = scan.next();		
					
					// validate login
					Boolean isLoggedIn = userService.Login(username, password);
					if(isLoggedIn) {
						System.out.println("\nYou have logged in");
					}
					else {
						System.out.println("\nusername and password combination incorrect or does not exist");
						break;
					}
					
					// menus
					CRSStudentMenu studentMenu = new CRSStudentMenu(scan, username);
					CRSProfessorMenu professorMenu = new CRSProfessorMenu(scan, username);
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
		
		userService.Logout(username, password);
		System.out.println("\nEnd of program");	
	}
}
