package com.lti.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lti.bean.Professor;
import com.lti.bean.Student;
import com.lti.bean.User;
import com.lti.bean.Course;
import com.lti.bean.CourseCatalog;
import com.lti.service.ProfessorService;

public class CRSProfessorMenu {
	
	private Scanner scan;
	private User user;
	private Professor professor;
	private ProfessorService professorService;
	
	public CRSProfessorMenu(Scanner scan, User user) {
		
		this.scan = scan;
		this.user = user;
		
		professor = new Professor();
		professorService = new ProfessorService();

	}
	
	public void menu() {
		
		// need to get professor from db - create professor instance
		professor = professorService.getProfessor(user.getId());

		// menu
		while(true)
		{
			System.out.println("\nEnter selection: ");
			System.out.println("1. Add Grades");
			System.out.println("2. View Enrolled Students");
			System.out.println("3. Back (previous menu)");
			System.out.print("\n-> ");
			
			String professorSelection = scan.nextLine();
			if(professorSelection == "") {
				professorSelection = scan.nextLine();
			}
			
			Boolean professor_back = false;
			
			switch(professorSelection.toLowerCase()) {
				case "add grades":
					
					// TODO: need to get and display a list of enrolled students in the course
					System.out.println("\nList of courses: ");
					List<CourseCatalog> courses = professorService.getProfessorCourses(professor.getId());
					System.out.format("%16s%16s%16s%16s%16s", 
							"COURSEID",
							"CREDITS",
							"CAPACITY",
							"ENROLLED",
							"SEMESTER");
					for(CourseCatalog course : courses) {
						System.out.format("%16s%16s%16s%16s%16s", 
								course.getId(),
								course.getCredits(),
								course.getCapacity(),
								course.getEnrolled(),
								course.getSemester());
					}
					
					
					// prompt professor to select a course
					System.out.print("\nSelect a course by ID: ");
					int courseId = scan.nextInt();
					
					// prompt professor to select a student
					System.out.print("\nSelect a student by ID: ");
					int studentId = scan.nextInt();
					
					// prompt professor to enter a grade for that student
					System.out.print("\nEnter grade for this student: ");
					String grade = scan.nextLine();
					
					
					professorService.addGrades(studentId, courseId, grade);
					
					break;
				case "view enrolled students":
	
					break;
				case "back":
					professor_back = true;
					break;
				default:
					System.out.println("Incorrect input, try again");
					continue;
			}
			if(professor_back) break;		//   exit from professor menu while loop
		}
	}
}
