package com.lti.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lti.bean.Admin;
import com.lti.bean.Student;

public class CRSAdminMenu {
	
	private Scanner scan;
	private String username;
	
	private Admin charlie = new Admin(1000, "Charlie");
	private int adminMaxId = 1000;		
	private List<Admin> admins = new ArrayList<Admin>();
	private Admin admin;
	
	public CRSAdminMenu(Scanner scan, String username) {
		
		this.scan = scan;
		this.username = username;
		
		admin = new Admin();
		
		admins.add(charlie);
	}
	
	public void menu() {
		
		// use existing admin or create new 
		switch(username) {
			case "charlie":
				admin = charlie;
			default:
				admin = new Admin(adminMaxId + 1, username);				
		}
		
		admins.add(admin);
		
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
