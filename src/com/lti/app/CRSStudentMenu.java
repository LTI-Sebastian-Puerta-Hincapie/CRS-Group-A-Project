package com.lti.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.lti.bean.Course;
import com.lti.bean.CourseCatalog;
import com.lti.bean.Grade;
import com.lti.bean.Payment;
import com.lti.bean.RegisteredCourse;
import com.lti.bean.Student;
import com.lti.bean.User;
import com.lti.service.CourseCatalogOperation;
import com.lti.service.CourseCatalogService;
import com.lti.service.StudentService;
import com.lti.service.StudentServiceOperation;

public class CRSStudentMenu {
	
	private Scanner scan;
	private User user;
	private CourseCatalogOperation courseCatalogService;
	private StudentServiceOperation studentService;
	
	public CRSStudentMenu(Scanner scan, User user) {
		
		this.scan = scan;
		this.user = user;
		
		this.studentService = new StudentService();
		this.courseCatalogService = new CourseCatalogService();
	}
	
	public void menu() {
		
		// create student instance
		Student student = studentService.getStudent(user.getId());
		
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
				case "register for course":
					
					System.out.println("\nCourses added:");
					System.out.format("%16s%16s\n", 
							"ID",
							"NAME");
					for(Course course : studentService.getStudentCourses(student.getId())) {
						System.out.format("%16s%16s\n", 
								course.getCourseId(), 
								course.getCourseName());
					}
					
					System.out.print("\nRegister for a course, select by ID -> ");
					int courseId = scan.nextInt();
					
				    studentService.registerForCourse(student, courseId);
					System.out.println("\n-- You have registered for a course --");	
					
					System.out.println("\nCourses you have registered for:");
					System.out.format("%16s%32s\n", 
							"COURSEID",
							"REGISTRATIONSTATUS");
					
					for(RegisteredCourse course : studentService.getStudentRegisteredCourses(student.getId())) {
						System.out.format("%16s%32s\n", 
								course.getCourseId(), 
								course.getRegisteredStatus() == 1 ? "Yes" : "No");
					}	
					
					// add payment data to payment table
					
					
					break;
				case "add course":
					
					// get all available courses
					List<CourseCatalog> courseCatalog = courseCatalogService.ListOfAllCourses();
					
					System.out.println("\nCourse Catalog:");
					System.out.format("%16s%16s%16s%16s%16s%16s%16s%16s\n", 
							"ID",
							"PROFESSORID", 
							"DEPARTMENTID", 
							"PREREQUISITE",
							"CREDITS",
							"CAPACITY",
							"ENROLLED",
							"SEMESTER");
					
					for(CourseCatalog course : courseCatalog) {
						System.out.format("%16d%16d%16d%16s%16d%16d%16d%16s\n", 
								course.getId(), 
								course.getProfessorId(),
								course.getDepartmentId(), 
								course.getPrerequisites(), 
								course.getCredits(),
								course.getCapacity(),
								course.getEnrolled(),
								course.getSemester());
					}

					System.out.print("\nSelect course to add by Id -> ");
					course_id_selected = scan.nextInt();
					
					studentService.addCourse(student, course_id_selected);
					System.out.println("\n-- Course has been added --");
					
					System.out.println("\nCourses added:");
					System.out.format("%16s%16s\n", 
							"ID",
							"NAME");
					for(Course course : studentService.getStudentCourses(student.getId())) {
						System.out.format("%16s%16s\n", 
								course.getCourseId(), 
								course.getCourseName());
					}
					break;
				case "drop course":
					
					System.out.println("\nCourses added:");
					System.out.format("%16s%16s\n", 
							"ID",
							"NAME");
					for(Course course : studentService.getStudentCourses(student.getId())) {
						System.out.format("%16s%16s\n", 
								course.getCourseId(), 
								course.getCourseName());
					}
					
					System.out.print("\nSelect course to drop by Id -> ");
					course_id_selected = scan.nextInt();
					
					studentService.dropCourse(student, course_id_selected);
					System.out.println("\n-- Course has been dropped --");
					
					System.out.println("\nCourses added:");
					System.out.format("%16s%16s\n", 
							"ID",
							"NAME");
					for(Course course : studentService.getStudentCourses(student.getId())) {
						System.out.format("%16s%16s\n", 
								course.getCourseId(), 
								course.getCourseName());
					}
					
					break;
				case "view grades":
					
					List<Grade> grades = studentService.viewGrades(student);
					
					System.out.println("\nStudent Course Grades:");
					System.out.format("%16s%16s%16s\n", 
							"COURSEID",
							"COURSENAME",
							"GRADE");
					for(Grade grade : grades) {
						System.out.format("%16s%16s%16s\n", 
								grade.getCourse().getCourseId(), 
								grade.getCourse().getCourseName(),
								grade.getGrade());
					}
					
					break;
				case "pay fee":
					
					System.out.println("\n--UNDER CONSTRUCTION--");
					
					// TODO: Validate if the student has registered for any courses
					
					// TODO: Display list of registered courses
					
					// TODO: Based on the registered courses perform payment operation
					
					// TODO: Display payment due
					
//					Payment payment = new Payment(student);
//					int totalNumberOfCredits = 0;
//					System.out.println("\nFee per credit: " + payment.COST_PER_CREDIT);
//					for(Course course : student.getCourses()) {
//						
//						totalNumberOfCredits += course.getCredits();
//					}
//					System.out.println("Total number of courses added: " + student.getCourses().size());
//					System.out.println("Total number of credits: " + totalNumberOfCredits);
//					
//					double totalFee = payment.COST_PER_CREDIT * totalNumberOfCredits;
//					System.out.println("Total fee: " + totalFee);
//					
//					System.out.println("\nPayment Method:");
//					System.out.println("1. Credit");
//					System.out.println("2. Debit");
//					System.out.println("3. Direct Withdrawal");
//					System.out.println("4. Paypal");
//					System.out.println("5. Pay in person");
//					System.out.println("6. Back");
//					System.out.print("\n-> ");
//					
//					String paymentMethod = scan.nextLine();	
//					
//					switch(paymentMethod) {
//						case "credit": 
//							studentService.payFee(student, paymentMethod);
//							System.out.println("\n--Payment Complete--");
//							break;
//						case "debit": 
//							studentService.payFee(student, paymentMethod);
//							System.out.println("\n--Payment Complete--");
//							break;
//						case "direct withdrawal": 
//							studentService.payFee(student, paymentMethod);
//							System.out.println("\n--Payment Complete--");
//							break;
//						case "paypal": 
//							studentService.payFee(student, paymentMethod);
//							System.out.println("\n--Payment Complete--");
//							break;
//						case "pay in person": 
//							studentService.payFee(student, paymentMethod);
//							System.out.println("\n--Payment Complete--");
//							break;
//						case "back": break;
//						default:
//							System.out.println("No course have been added to your cart, please add a course");
//					}
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
