package com.lti.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lti.bean.Student;
import com.lti.service.StudentService;
import com.lti.service.StudentServiceOperation;

public class CRSStudentMenu {
	
	private Scanner scan;
	private String username;
	
	// In-memory test data - initial data
	private Student thomas = new Student(1, "Thomas", "Biology");
	private Student abigail = new Student(2, "Abigail", "Psychology");
	private Student tej = new Student(3, "Tej", "Economics");
	private int studentMaxId = 3;
	private List<Student> students = new ArrayList<Student>();
	private Student student;
	private StudentServiceOperation service;
	
	public CRSStudentMenu(Scanner scan, String username) {
		
		this.scan = scan;
		this.username = username;
		
		this.student = new Student();
		this.service = new StudentService();
		
		students.add(thomas);
		students.add(abigail);
		students.add(tej);
	}
	
	public void menu() {
		
		// use existing student or create new 
		switch(username.toLowerCase()) {
			case "thomas": 
				student = thomas;
				break;
			case "abigail":
				student = abigail;
				break;
			case "tej":
				student = tej;
			default:
				student = new Student(studentMaxId + 1, username, "undefined");				
		}
		
		students.add(student);
		
		// menu
		while(true)
		{
			System.out.println("\nEnter selection: ");
			System.out.println("1. Register for course");
			System.out.println("2. Add course");
			System.out.println("3. Drop course");
			System.out.println("4. View grades");
			System.out.println("5. Pay fee");
			System.out.println("6. Back (previous menu)");
			System.out.print("\n-> ");
			
			String studentSelection = scan.nextLine();
			if(studentSelection == "") {
				studentSelection = scan.nextLine();
			}
			
			Boolean student_back = false;
			
			switch(studentSelection.toLowerCase()) {
				case "register for courses":
					//TODO: complete functionality
					service.registerForCourse(student, null, true);
					System.out.println("Registering for course...");		
					break;
				case "add course":
					//TODO: complete functionality
					service.addCourse(student, null);
					System.out.println("Adding course...");
					break;
				case "drop course":
					//TODO: complete functionality
					service.dropCourse(student, null);
					System.out.println("Dropping course");
					break;
				case "view grades":
					//TODO: complete functionality
					service.viewGrades(student);
					System.out.println("Viewing grades...");
					break;
				case "pay fee":
					//TODO: complete functionality
					service.payFee(student);
					System.out.println("Paying fee...");
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
	}

}
