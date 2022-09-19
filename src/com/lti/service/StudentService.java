package com.lti.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lti.bean.Course;
import com.lti.bean.Payment;
import com.lti.bean.Student;

// TODO define all services method based on the use case diagram
public class StudentService implements StudentServiceOperation {
	
	private Map<Student, Course> addedCourses;
	
	public StudentService() {
		
		addedCourses = new HashMap<Student,Course>();
	}
	
	public void registerForCourse(Student student, Course course) {
		
		student.registerCourse(course);
	}
	
	public void addCourse(Student student, Course course) {
		
		student.addCourse(course);
		addedCourses.put(student, course);
	}
	
	public void dropCourse(Student student, Course course) {
		
		student.dropCourse(course);
		addedCourses.remove(student, course);
	}

	public void viewGrades(Student student) {
		
		System.out.println("\nNo grades have been entered, please comeback at a later time");
	}
	
	public void payFee(Student student, String paymentMethod) {
		
		System.out.println("\nYou have opted to pay: " + paymentMethod);
	}
}
