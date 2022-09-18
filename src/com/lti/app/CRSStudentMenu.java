package com.lti.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lti.bean.Course;
import com.lti.bean.CourseCatalog;
import com.lti.bean.Payment;
import com.lti.bean.Student;
import com.lti.service.StudentService;
import com.lti.service.StudentServiceOperation;

public class CRSStudentMenu {
	
	private Scanner scan;
	private String username;
	private Student student;
	private StudentServiceOperation service;
	
	// default data - initial in-memory data
	private Student thomas = new Student(1, "Thomas", "Biology");
	private Student abigail = new Student(2, "Abigail", "Psychology");
	private Student tej = new Student(3, "Tej", "Economics");
	private int studentMaxId = 3;
	private List<Student> students;
	private CourseCatalog catalog;
	
	public CRSStudentMenu(Scanner scan, String username) {
		
		this.scan = scan;
		this.username = username;
		
		this.student = new Student();
		this.service = new StudentService();
		
		students = new ArrayList<Student>();
		students.add(thomas);
		students.add(abigail);
		students.add(tej);
		
		catalog = new CourseCatalog();
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
		
		// course catalog
		ArrayList<Course> courses = catalog.getCourses();
		
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
			int course_id_selected = -1;
			
			switch(studentSelection.toLowerCase()) {
				case "register for courses":
					//TODO: complete functionality
					service.registerForCourse(student, null);
					System.out.println("Registering for course...");		
					break;
				case "add course":
					
					System.out.println("\nAvailable courses:");
					
					System.out.format("%4s%16s%16s%16s%16s%12s\n", 
							"ID",
							"NAME", 
							"PROFESSOR", 
							"DEPARTMENT", 
							"PREREQUISITE",
							"CREDITS");
					for(int i = 0; i < catalog.getCourses().size(); i++) {

						System.out.format("%4s%16s%16s%16s%16s%12s\n", 
								Integer.toString(courses.get(i).getId()),
								courses.get(i).getName(), 
								courses.get(i).getProfessor(),
								courses.get(i).getDepartment(), 
								courses.get(i).getPrerequisites(),
								Integer.toString(courses.get(i).getCredits()));
					}
					System.out.print("\nSelect course to add by Id -> ");
					course_id_selected = scan.nextInt();
					
					service.addCourse(student, courses.get(course_id_selected));
					System.out.println("\n-- Course has been added --");
					
					System.out.println("\nCourses in your cart:");
					System.out.format("%4s%16s%16s%16s%16s%12s\n", 
							"ID",
							"NAME", 
							"PROFESSOR", 
							"DEPARTMENT", 
							"PREREQUISITE",
							"CREDITS");
					for(Course course : student.getCourses()) {
						System.out.format("%4s%16s%16s%16s%16s%12s\n", 
								course.getId(), 
								course.getName(), 
								course.getProfessor(),
								course.getDepartment(), 
								course.getPrerequisites(), 
								course.getCredits());
					}
					break;
				case "drop course":
					
					System.out.println("\nCourses in your cart:");
					System.out.format("%4s%16s%16s%16s%16s%12s\n", 
							"ID",
							"NAME", 
							"PROFESSOR", 
							"DEPARTMENT", 
							"PREREQUISITE",
							"CREDITS");
					for(Course course : student.getCourses()) {
						System.out.format("%4s%16s%16s%16s%16s%12s\n", 
								course.getId(), 
								course.getName(), 
								course.getProfessor(),
								course.getDepartment(), 
								course.getPrerequisites(), 
								course.getCredits());
					}
					
					System.out.print("\nSelect course to drop by Id -> ");
					course_id_selected = scan.nextInt();
					
					service.dropCourse(student, courses.get(course_id_selected));
					System.out.println("\n-- Course has been dropped --");
					
					System.out.println("\nCourses in your cart:");
					System.out.format("%4s%16s%16s%16s%16s%12s\n", 
							"ID",
							"NAME", 
							"PROFESSOR", 
							"DEPARTMENT", 
							"PREREQUISITE",
							"CREDITS");
					for(Course course : student.getCourses()) {
						System.out.format("%4s%16s%16s%16s%16s%12s\n", 
								course.getId(), 
								course.getName(), 
								course.getProfessor(),
								course.getDepartment(), 
								course.getPrerequisites(), 
								course.getCredits());
					}
					
					break;
				case "view grades":
					//TODO: complete functionality
					service.viewGrades(student);
//					System.out.println("Viewing grades...");
					break;
				case "pay fee":
					
					Payment payment = new Payment(student);
					int totalNumberOfCredits = 0;
					System.out.println("\nFee per credit: " + payment.COST_PER_CREDIT);
					for(Course course : student.getCourses()) {
						
						totalNumberOfCredits += course.getCredits();
					}
					System.out.println("Total number of courses added: " + student.getCourses().size());
					System.out.println("Total number of credits: " + totalNumberOfCredits);
					
					double totalFee = payment.COST_PER_CREDIT * totalNumberOfCredits;
					System.out.println("Total fee: " + totalFee);
					
					System.out.println("\nPayment Method:");
					System.out.println("1. Credit");
					System.out.println("2. Debit");
					System.out.println("3. Direct Withdrawal");
					System.out.println("4. Paypal");
					System.out.println("5. Pay in person");
					System.out.println("6. Back");
					System.out.print("\n-> ");
					
					String paymentMethod = scan.nextLine();	
					
					switch(paymentMethod) {
						case "credit": 
							service.payFee(student, paymentMethod);
							System.out.println("\n--Payment Complete--");
							break;
						case "debit": 
							service.payFee(student, paymentMethod);
							System.out.println("\n--Payment Complete--");
							break;
						case "direct withdrawal": 
							service.payFee(student, paymentMethod);
							System.out.println("\n--Payment Complete--");
							break;
						case "paypal": 
							service.payFee(student, paymentMethod);
							System.out.println("\n--Payment Complete--");
							break;
						case "pay in person": 
							service.payFee(student, paymentMethod);
							System.out.println("\n--Payment Complete--");
							break;
						case "back": break;
						default:
							System.out.println("No course have been added to your cart, please add a course");
					}
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
