package com.lti.exception;

public class StudentCourseNotFoundException extends Exception {
	
	public StudentCourseNotFoundException() {
		super();
		System.out.println("This course is not associated to this student");
	}
}
