package com.lti.bean;

public class Grade {
	
	private char grade;
	private Course course;
	
	public Grade(char grade, Course course) {
		
		this.grade = grade;
		this.course = course;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
