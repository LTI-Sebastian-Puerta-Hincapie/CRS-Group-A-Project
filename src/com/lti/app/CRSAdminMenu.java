package com.lti.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lti.bean.Admin;
import com.lti.bean.Student;
import com.lti.service.AdminService;
import com.lti.service.AdminServiceOperation;

public class CRSAdminMenu {
	
	private Scanner scan;
	private String username;
	
	private Admin charlie = new Admin(1000, "Charlie");
	private int adminMaxId = 1000;		
	private List<Admin> admins = new ArrayList<Admin>();
	private Admin admin;
	private AdminServiceOperation service;
	
	public CRSAdminMenu(Scanner scan, String username) {
		
		this.scan = scan;
		this.username = username;
		
		admin = new Admin();
		
		admins.add(charlie);
		
		service = new AdminService();
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
					service.generateReportCard(null, null);
					System.out.println("Generating report card...");
					break;
				case "add professor":
					service.addProfessor(null);
					System.out.println("Adding professor...");
					break;
				case "view courses":
					service.viewCourses(null);
					System.out.println("Viewing courses...");
					break;
				case "approve registration":
					service.approveStudentRegistration(null);
					System.out.println("Approving registration...");
					break;
				case "add course":
					service.addCourse(null);
					System.out.println("Adding course...");
					break;
				case "drop course":
					service.removeCourse(0);
					System.out.println("Dropping course...");
					break;
				case "update course":
//					service.updateCourse(adminMaxId, adminSelection, adminSelection, adminSelection, adminSelection, adminMaxId);
					System.out.println("Updating course...");
					break;
				case "check availability":
					service.checkAvailability(0);
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
