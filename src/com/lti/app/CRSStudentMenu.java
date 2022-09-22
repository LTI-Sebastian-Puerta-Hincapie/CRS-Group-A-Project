package com.lti.app;

import java.util.List;
import java.util.Scanner;

import com.lti.bean.Course;
import com.lti.bean.CourseCatalog;
import com.lti.bean.Grade;
import com.lti.bean.Payment;
import com.lti.bean.RegisteredCourse;
import com.lti.bean.Student;
import com.lti.bean.User;
import com.lti.exception.PaymentBillNotCreatedException;
import com.lti.exception.RegisteredCourseNotFound;
import com.lti.exception.StudentAddCourseFailureException;
import com.lti.exception.StudentCourseNotFoundException;
import com.lti.exception.StudentDropCourseFailureException;
import com.lti.exception.StudentNotFoundException;
import com.lti.exception.StudentPayFeeFailureException;
import com.lti.exception.StudentPaymentRecordNotFoundException;
import com.lti.exception.UnableToViewStudentGradesException;
import com.lti.exception.StudentCourseRegistrationNotFoundException;
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
		Student student = null;
		List<Course> courses = null;
		List<RegisteredCourse> rcourses = null;
		
		try {
			student = studentService.getStudent(user.getId());
		} catch (StudentNotFoundException e) {
			e.getMessage();
			e.printStackTrace();
		} 
		
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
			
			// user input clean up
			studentSelection = studentSelection
					.toLowerCase()
					.replaceAll("^\\s+", "")
					.replaceAll("\\s+$", "");
			
			switch(studentSelection) {
				case "1": 
					studentSelection = "register for course";
					break;
				case "2": 
					studentSelection = "add course";
					break;
				case "3": 
					studentSelection = "drop course";
					break;
				case "4": 
					studentSelection = "view grades";
					break;
				case "5": 
					studentSelection = "pay fee";
					break;
				case "6": 
					studentSelection = "back";
					break;
			}
			
			Boolean student_back = false;
			int course_id_selected = -1;
			
			switch(studentSelection) {
				case "register for course":
					
					System.out.println("\nCourses added:");
					System.out.format("%16s%16s\n", 
							"ID",
							"NAME");
					
					try {
						courses = studentService.getStudentCourses(student.getId());
					} catch (StudentCourseNotFoundException e) {
						e.printStackTrace();
					}
					
					for(Course course : courses) {
						System.out.format("%16s%16s\n", 
								course.getCourseId(), 
								course.getCourseName());
					}
					
					System.out.print("\nRegister for a course, select by ID -> ");
					int courseId = scan.nextInt();
					
					try {
						studentService.registerForCourse(student, courseId);
					} catch (StudentCourseRegistrationNotFoundException e) {
						e.printStackTrace();
					}
					System.out.println("\n-- You have registered for a course --");	
					
					System.out.println("\nCourses you have registered for:");
					System.out.format("%16s%32s\n", 
							"COURSEID",
							"REGISTRATIONSTATUS");
					

					try {
						rcourses = studentService.getStudentRegisteredCourses(student.getId());
					} catch (RegisteredCourseNotFound e) {
						e.printStackTrace();
					}
					
					for(RegisteredCourse course : rcourses) {
						System.out.format("%16s%32s\n", 
								course.getCourseId(), 
								course.getRegisteredStatus() == 1 ? "Yes" : "No");
					}	
					
					// add payment data to payment table
					try {
						studentService.generatePayment(student.getId());
					} catch (PaymentBillNotCreatedException e) {
						e.printStackTrace();
					}
					
					// add student semester registration
					studentService.addStudentSemesterRegistration(student.getId());
					
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
					
					try {
						studentService.addCourse(student, course_id_selected);
					} catch (StudentAddCourseFailureException e) {
						e.printStackTrace();
					}
					System.out.println("\n-- Course has been added --");
					
					System.out.println("\nCourses added:");
					System.out.format("%16s%16s\n", 
							"ID",
							"NAME");
					
					try {
						courses = studentService.getStudentCourses(student.getId());
					} catch (StudentCourseNotFoundException e) {
						e.printStackTrace();
					}
					for(Course course : courses) {
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
					
					try {
						courses =  studentService.getStudentCourses(student.getId());
					} catch (StudentCourseNotFoundException e1) {
						e1.printStackTrace();
					}
					
					for(Course course : courses) {
						System.out.format("%16s%16s\n", 
								course.getCourseId(), 
								course.getCourseName());
					}
					
					System.out.print("\nSelect course to drop by Id -> ");
					course_id_selected = scan.nextInt();
					
					try {
						studentService.dropCourse(student, course_id_selected);
					} catch (StudentDropCourseFailureException e) {
						e.printStackTrace();
					}
					System.out.println("\n-- Course has been dropped --");
					
					System.out.println("\nCourses added:");
					System.out.format("%16s%16s\n", 
							"ID",
							"NAME");
					
					try {
						courses = studentService.getStudentCourses(student.getId());
					} catch (StudentCourseNotFoundException e) {
						e.printStackTrace();
					}
					for(Course course : courses) {
						System.out.format("%16s%16s\n", 
								course.getCourseId(), 
								course.getCourseName());
					}
					
					break;
				case "view grades":
					
					List<Grade> grades = null;
					try {
						grades = studentService.viewGrades(student);
					} catch (UnableToViewStudentGradesException e) {
						e.printStackTrace();
					}
					
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
					
					try {
						rcourses = studentService.getStudentRegisteredCourses(student.getId());
					} catch (RegisteredCourseNotFound e) {
						e.printStackTrace();
					}
					if(rcourses.size() == 0) {
						System.out.println("\nYou have not registered for any courses yet, please register.");
						break;
					}
					
					System.out.println("\nCourses you have registered for:");
					System.out.format("%16s%32s\n", 
							"COURSEID",
							"REGISTRATIONSTATUS");
					
					for(RegisteredCourse course : rcourses) {
						System.out.format("%16s%32s\n", 
								course.getCourseId(), 
								course.getRegisteredStatus() == 1 ? "Yes" : "No");
					}			
					
					Payment payment = null;
					try {
					    payment = studentService.getFee(student.getId());
					} catch (StudentPaymentRecordNotFoundException e) {
						e.printStackTrace();
					}

					System.out.format("\n%16s%16s\n", "Amount", "Due Date");
					System.out.format("%16s%16s", 
							payment.getPaymentAmount(), 
							payment.getDueDate());
					
					System.out.print("\nPayment Method: ");
					String paymentMethod = scan.nextLine();
					
					try {
						studentService.payFee(student, paymentMethod);
					} catch (StudentPayFeeFailureException e) {
						e.printStackTrace();
					}
						
					System.out.println("\n--PAYMENT COMPLETE--");
					
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
