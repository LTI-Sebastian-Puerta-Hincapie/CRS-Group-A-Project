package com.lti.service;

import java.util.ArrayList;
import java.util.HashMap;
import com.lti.bean.Admin;
import com.lti.bean.Course;
import com.lti.bean.CourseCatalog;
import com.lti.bean.Professor;
import com.lti.bean.Student;

public class AdminService implements AdminServiceOperation {
	
	private HashMap<Integer,Professor> professors;
	private HashMap<Integer,Course> courses;
	
	public AdminService() {
		this.professors = new HashMap<Integer,Professor>();
		this.courses = new HashMap<Integer,Course>();
	}

	public void generateReportCard(Student student, Professor professor) {
		System.out.println("Generating report card for " + student.getName() + " by " + professor.getName());
	}
	
	public void addProfessor(Professor professor) {
		this.professors.put(professor.getId(), professor);
	}
	
	public void approveStudentRegistration(Student student) {
		System.out.println("Registration for " + student.getName() + " is approved");
	}
	
	public void addCourse(Course course) {
		this.courses.put(course.getId(), course);
	}
	
	public void removeCourse(int id) {
		this.courses.remove(id);
	}
	
	public void updateCourse(int id, String name, String professor, String department, String prerequisites, int credits) {
		this.courses.get(id).setName(name);
		this.courses.get(id).setProfessor(professor);
		this.courses.get(id).setDepartment(department);
		this.courses.get(id).setPrerequisites(prerequisites);
		this.courses.get(id).setCredits(credits);
	}
	
	public void checkAvailability(int id) {
		if(courses.containsKey(id)) {
			System.out.println("The course " + courses.get(id).getName() + " (" + courses.get(id).getId() + ") is available.");
		}
		else {
			System.out.println("The course is not available");
		}
	}
	
	public void viewCourses(Student student) {
		System.out.println("Listing course list for " + student.getName() + ":");
		for(Course course : student.getCourses()) {
			System.out.println(course.getId() + ": " + course.getName());
		}
	}
}
