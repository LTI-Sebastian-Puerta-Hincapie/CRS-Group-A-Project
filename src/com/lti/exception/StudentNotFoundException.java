package com.lti.exception;

public class StudentNotFoundException extends Exception {
	
	public StudentNotFoundException() {
		super();
		System.out.println("\nStudent does not exist");
	}
}
