package com.lti.exception;

public class IncorrectPasswordException extends Exception {
	
	public IncorrectPasswordException() {
		System.out.println("\nEntered password does not match existing password");
	}
}
