package com.lti.exception;

public class StudentCourseRegistrationNotFoundException extends Exception {
	
	public StudentCourseRegistrationNotFoundException() {
		super();
		System.out.println("Student has not been registered");
	}
}
