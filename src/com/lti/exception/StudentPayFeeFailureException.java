package com.lti.exception;

public class StudentPayFeeFailureException extends Exception {
	
	public StudentPayFeeFailureException() {
		super();
		System.out.println("Failed to pay fee");
	}
}
