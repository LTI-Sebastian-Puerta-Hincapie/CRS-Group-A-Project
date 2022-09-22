package com.lti.exception;

public class RegisteredCourseNotFound extends Exception {
	
	public RegisteredCourseNotFound() {
		super();
		System.out.println("Coures has not been registered");
	}
}
