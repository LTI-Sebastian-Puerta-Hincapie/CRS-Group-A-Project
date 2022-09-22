package com.lti.exception;

public class StudentPaymentRecordNotFoundException extends Exception {

	public StudentPaymentRecordNotFoundException() {
		super();
		System.out.println("Payment record not found for this student");
	}
}
