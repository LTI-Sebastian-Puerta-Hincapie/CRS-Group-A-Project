package com.lti.service;

import com.lti.bean.Course;
import com.lti.bean.Student;

// TODO define all services method based on the use case diagram
public class StudentService {

	
	public void registerForCourse(Student student, Course course, Boolean register) {
		System.out.println("Register for a course");
	}
	
	public void addCourse(Student student, Course course) {
		System.out.println("Add a course");
	}
	
	public void dropCourse(Student student, int id) {
		System.out.println("Drop a course");
	}
	
	public void viewGrades(Student student) {
		System.out.println("View grades");
	}
	
	public void payFee(Student student) {
		System.out.println("Pay fee");
	}
}
