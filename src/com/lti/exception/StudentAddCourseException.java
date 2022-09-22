package com.lti.exception;

public class StudentAddCourseException extends Exception {
	
	public StudentAddCourseException() {
		super();
		System.out.println("Failure when adding course");
	}
}
