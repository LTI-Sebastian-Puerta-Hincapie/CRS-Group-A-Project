package com.lti.exception;

public class UserNotFoundException extends Exception {
	
	public UserNotFoundException() {
		super();
		System.out.println("\nUser not found");
	}
}
