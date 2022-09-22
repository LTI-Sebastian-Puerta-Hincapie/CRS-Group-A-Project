package com.lti.exception;

public class StudentDropCourseFailureException extends Exception {
	
	public StudentDropCourseFailureException() {
		super();
		System.out.println("Failed to drop course");
	}
}
