package com.lti.exception;

public class StudentPaymentRecordNotFoundException extends Exception {

	public StudentPaymentRecordNotFoundException() {
		System.out.println("Student payment record not found");
	}
}
