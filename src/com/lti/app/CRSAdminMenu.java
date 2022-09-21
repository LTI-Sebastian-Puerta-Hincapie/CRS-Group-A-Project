package com.lti.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lti.bean.Admin;
import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.bean.Student;
import com.lti.service.AdminService;
import com.lti.service.AdminServiceOperation;

public class CRSAdminMenu {
	
	private Scanner scan;
	private String username;
	
//	private Admin charlie = new Admin(1000, "Charlie");
	private int adminMaxId = 1000;		
	private List<Admin> admins = new ArrayList<Admin>();
	private Admin admin;
	private AdminServiceOperation service;
	
	public CRSAdminMenu(Scanner scan, String username) {
		
		this.scan = scan;
		this.username = username;
		
		admin = new Admin();
		
//		admins.add(charlie);
		
		service = new AdminService();
	}
	
	public void menu() {
		
		// use existing admin or create new 
		switch(username) {
			case "charlie":
//				admin = charlie;
			default:
//				admin = new Admin(adminMaxId + 1, username);				
		}
		
		admins.add(admin);
		
		// menu
		while(true)
		{
			System.out.println("\nEnter selection: ");
			System.out.println("1. Generate Report Card");
			System.out.println("2. Approve Registration");
			System.out.println("3. Add Professor");
			System.out.println("4. Add Course");
			System.out.println("5. Remove Course");
			System.out.println("6. Update Course");
			System.out.println("7. Check Availability");
			System.out.println("8. View Courses");
			System.out.println("9. Back (previous menu)");
			System.out.print("\n-> ");
			
			String adminSelection = scan.nextLine();
			if(adminSelection == "") {
				adminSelection = scan.nextLine();
			}
			
			Boolean admin_back = false;
			
			switch(adminSelection.toLowerCase()) {
				case "generate report card":
					System.out.println("Enter student ID:");
					int studentID = Integer.parseInt(scan.nextLine());
					service.generateReportCard(studentID);
					break;
				case "add professor":
					System.out.println("Enter Professor ID: ");
					int professorID = Integer.parseInt(scan.nextLine());
					System.out.println("Enter Professor Name: ");
					String professorName = scan.nextLine();
					System.out.println("Enter Professor Department ID");
					int departmentID = Integer.parseInt(scan.nextLine());
					System.out.println("Enter Professor Email: ");
					String email = scan.nextLine();
					System.out.println("Enter Professor Phone: ");
					String phone = scan.nextLine();
					System.out.println("Enter Professor Address: ");
					String address = scan.nextLine();
					service.addProfessor(new Professor(professorID,professorName,departmentID,email,phone,address));
					break;
				case "view courses":
					System.out.println("Enter student ID:");
					studentID = Integer.parseInt(scan.nextLine());
					service.viewCourses(studentID);
					break;
				case "approve registration":
					service.approveStudentRegistration(null);
					System.out.println("Approving registration...");
					break;
				case "add course":
					System.out.println("Enter Course ID: ");
					int courseID = Integer.parseInt(scan.nextLine());
					System.out.println("Enter Course Name: ");
					String courseName = scan.nextLine();
					System.out.println("Enter Course Description: ");
					String description = scan.nextLine();
					service.addCourse(new Course(courseID,courseName,description));
					break;
				case "drop course":
					System.out.println("Enter Course ID: ");
					courseID = Integer.parseInt(scan.nextLine());
					service.removeCourse(courseID);
					break;
				case "update course":
					System.out.println("Enter Course ID: ");
					courseID = Integer.parseInt(scan.nextLine());
					System.out.println("Enter Course Name: ");
					courseName = scan.nextLine();
					System.out.println("Enter Course Description: ");
					description = scan.nextLine();
					service.updateCourse(courseID,courseName,description);
					System.out.println("Updating course...");
					break;
				case "remove course":
					System.out.println("Enter Course ID: ");
					courseID = Integer.parseInt(scan.nextLine());
					service.removeCourse(courseID);
					break;
				case "check availability":
					System.out.println("Enter course ID:");
					courseID = Integer.parseInt(scan.nextLine());
					service.checkAvailability(courseID);
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
