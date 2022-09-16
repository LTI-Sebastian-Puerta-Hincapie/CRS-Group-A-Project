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
			System.out.println("Enter selection: ");
			System.out.println("1. Login");
			System.out.println("2. Student Registration");
			System.out.println("3. Update Password");
			System.out.println("4. Exit");
			System.out.print("\n-> ");
			
			String selection = scan.next();
			switch(selection.toLowerCase()) {
				case "login":
					
					System.out.print("Enter Username: ");
					String username = scan.next();
					
					System.out.print("Enter Password: ");
					String password = scan.next();
					
					// TODO: login credential validation method here						
					
					// Role Selection Loop
					while(true) {
					
						System.out.println("Enter Role: ");
						System.out.println("1. Student");
						System.out.println("2. Professor");
						System.out.println("3. Admin");
						System.out.print("\n-> ");
						String role = scan.next();
						
						Boolean role_back = false;
						switch(role.toLowerCase()) {
							case "student": 
								System.out.println("\nWelcome Student");
								
								// menu
								while(true)
								{
									System.out.println("\nEnter selection: ");
									System.out.println("1. Register for courses");
									System.out.println("2. Add course");
									System.out.println("3. Drop course");
									System.out.println("4. View grade");
									System.out.println("5. Pay fee");
									System.out.println("6. Back (previous menu)");
									System.out.print("\n-> ");
									String studentSelection = scan.nextLine();
									
									Boolean student_back = false;
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
										case "back":
											student_back = true;
											break;
										default:
											System.out.println("Incorrect input, try again");
											continue;
									}
									
									if(student_back) break;		//   exit from student menu while loop
								}
								break;			// student switch case break
							case "professor": 
								System.out.println("\nWelcome Professor");
								// menu
								while(true)
								{
									System.out.println("\nEnter selection: ");
									System.out.println("1. Add Grades");
									System.out.println("2. View Enrolled Students");
									System.out.println("3. Back (previous menu)");
									System.out.print("\n-> ");
									String professorSelection = scan.nextLine();
									
									Boolean professor_back = false;
									switch(professorSelection.toLowerCase()) {
										case "add grades":
											System.out.println("Adding grades...");
											break;
										case "view enrolled students":
											System.out.println("Viewing enrolled students...");
											break;
										case "back":
											professor_back = true;
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
									System.out.println("\nEnter selection: ");
									System.out.println("1. Generate Report Card");
									System.out.println("2. Approve Registration");
									System.out.println("3. Add Course");
									System.out.println("4. Remove Course");
									System.out.println("5. Update Course");
									System.out.println("6. Check Availability");
									System.out.println("7. View Courses");
									System.out.println("7. Back (previous menu)");
									System.out.print("\n-> ");
									String adminSelection = scan.nextLine();
									
									Boolean admin_back = false;
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
										case "back":
											admin_back = true;
											break;
										default:
											System.out.println("Incorrect input, try again");
									}
									
									if(admin_back) break;		//   exit from admin menu while loop
								}
								break;					// admin switch case
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
