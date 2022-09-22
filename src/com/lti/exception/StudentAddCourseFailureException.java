package com.lti.exception;

public class StudentAddCourseFailureException extends Exception {
	
	public StudentAddCourseFailureException() {
		super();
		System.out.println("Failed to add course");
	}
}
