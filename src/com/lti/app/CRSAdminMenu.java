package com.lti.app;

import java.util.Scanner;

public class CRSAdminMenu {
	
	Scanner scan;
	
	public CRSAdminMenu(Scanner scan) {
		this.scan = scan;
	}
	
	public void menu() {
		
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
			if(adminSelection == "") {
				adminSelection = scan.nextLine();
			}
			
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
	}
}
