package com.lti.app;

import java.util.Scanner;

public class CRSMenuApplication {

	public static void main(String[] args) {
		// TODO design the menu as per the user input from the console
		// based on some switch case
		Scanner scan = new Scanner(System.in);
		System.out.println("******************Welcome to the CRS Application*************");
		
		// Main menu selection loop
		while(true) {
			System.out.println("Main Menu(Login, registration, Update, Exit)");
			System.out.print("Enter selection: ");
			
			String selection = scan.next();
			switch(selection.toLowerCase()) {
				case "login":
					// Role Selection Loop
					while(true) {
						
						System.out.print("Enter Username: ");
						String username = scan.next();
						
						System.out.print("Enter Password: ");
						String password = scan.next();
						
						// TODO: login credential validation method here
						
						System.out.println("Roles(Student, Professor, Admin)");
						System.out.print("Enter Role: ");
						String role = scan.next();
						
						switch(role.toLowerCase()) {
							case "student": 
								System.out.println("\nWelcome Student");
								
								// menu
								while(true)
								{
									System.out.println("Menu(register for courses, add course, drop course, view grades, pay fee)");
									System.out.print("Enter selection: ");
									String studentSelection = scan.nextLine();
									
									switch(studentSelection.toLowerCase()) {
										case "register for courses":
											System.out.println("Registering for courses...");
											break;
										case "add course":
											System.out.println("Adding course...");
											break;
										case "drop course":
											System.out.println("Dropping course");
											break;
										case "view grades":
											System.out.println("Viewing grades...");
											break;
										case "pay fee":
											System.out.println("Paying fee");
											break;
										default:
											System.out.println("Incorrect input, try again");
											continue;
									}
									break;		//   exit from student menu while loop
								}
								break;			// student switch case break
							case "professor": 
								System.out.println("\nWelcome Professor");
								// menu
								while(true)
								{
									System.out.println("Menu(add grades, view enrolled students)");
									System.out.print("Enter selection: ");
									String professorSelection = scan.nextLine();
									
									switch(professorSelection.toLowerCase()) {
										case "add grades":
											System.out.println("Adding grades...");
											break;
										case "view enrolled students":
											System.out.println("Viewing enrolled students...");
											break;
										default:
											System.out.println("Incorrect input, try again");
											continue;
									}
									break;		//   exit from professor menu while loop
								}
								break;		// professor switch case break
							case "admin": 
								System.out.println("\nWelcome Admin");
								// menu
								while(true)
								{
									System.out.println("Menu(generate report card, add professor, view courses" +
										"approve registration, add course, remove course, update course, check availability)");
									System.out.print("Enter selection: ");
									String adminSelection = scan.nextLine();
									
									switch(adminSelection.toLowerCase()) {
										case "generate report card":
											System.out.println("Generating report card...");
											break;
										case "add professor":
											System.out.println("Adding professor...");
											break;
										case "view courses":
											System.out.println("Viewing courses...");
											break;
										case "approve registration":
											System.out.println("Approving registration...");
											break;
										case "add course":
											System.out.println("Adding course...");
											break;
										case "drop course":
											System.out.println("Dropping course...");
											break;
										case "update course":
											System.out.println("Updating course...");
											break;
										case "check availability":
											System.out.println("Checking availability...");
											break;
										default:
											System.out.println("Incorrect input, try again");
											continue;
									}
									break;		//   exit from admin menu while loop
								}
								break;
							default:
								System.out.println("Please make another selection, role not found\n");
								continue;
						}
						break;  // exit out of role while loop
					}	
					break;  // admin switch case break
				case "registration": 
					System.out.println("Student Registration...");
					break;
				case "update": 
					System.out.println("Updating Password...");
					break;
				case "exit": 
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Please make another selection, option not found\n");
					continue;
			}
			
			break;    // exit out of main menu loop
		}
		System.out.println("\nEnd of program");	
	}
}
