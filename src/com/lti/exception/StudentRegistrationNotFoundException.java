package com.lti.exception;

public class StudentRegistrationNotFoundException extends Exception {
	
	public StudentRegistrationNotFoundException() {
		super();
		System.out.println("Student has not been registered");
	}
}
