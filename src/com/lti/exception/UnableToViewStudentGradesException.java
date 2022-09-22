package com.lti.exception;

public class UnableToViewStudentGradesException extends Exception {
	
	public UnableToViewStudentGradesException() {
		super();
		System.out.println("Unable to view student grades");
	}
}
