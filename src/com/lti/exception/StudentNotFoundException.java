package com.lti.exception;

public class StudentNotFoundException extends Exception {
	
	public StudentNotFoundException() {
		System.out.println("Student not found");
	}
}
