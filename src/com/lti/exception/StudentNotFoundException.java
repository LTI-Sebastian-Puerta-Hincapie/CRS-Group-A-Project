package com.lti.exception;

public class StudentNotFoundException extends Exception {
	
	public StudentNotFoundException() {
		
		System.out.println("\nStudent does not exist");
	}
}
