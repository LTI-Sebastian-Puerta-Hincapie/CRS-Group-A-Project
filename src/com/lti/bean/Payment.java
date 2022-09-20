package com.lti.bean;

public class Payment {
	
	private double fee;
	private int paymentId;
	private String modeOfPayment;     // debit, credit, cash
	private String description;		  // online or offline
	public final int COST_PER_CREDIT = 1125;
	private Student student;
	
	public Payment(Student student) {
		
		this.student = student;
	}
	
	/**
	 * @return the fee
	 */
	public double getFee() {
		
		int totalCredits = 0;
		for(Course course : this.student.getCourses()) {
			
//			totalCredits += course.getCredits();
		}
		
		fee = totalCredits * COST_PER_CREDIT;
		return fee;
	}

	/**
	 * @return the modeOfPayment
	 */
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	/**
	 * @param modeOfPayment the modeOfPayment to set
	 */
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	/**
	 * @return the paymentId
	 */
	public int getPaymentId() {
		return paymentId;
	}
	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
