package com.lti.exception;

public class IncorrectPasswordException extends Exception {
	
	public IncorrectPasswordException() {
		
		System.out.println("Entered password does not match existing password");
	}
}
