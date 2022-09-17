package com.lti.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lti.bean.Course;
import com.lti.bean.Student;

// TODO define all services method based on the use case diagram
public class StudentService implements StudentServiceOperation {
	
	private Map<Student, Course> addedCourses;
	
	public StudentService() {
		
		addedCourses = new HashMap<Student,Course>();
	}
	
	public void registerForCourse(Student student, Course course, Boolean register) {
		
	}
	
	public void addCourse(Student student, Course course) {
		
		student.addCourse(course);
		addedCourses.put(student, course);
	}
	
	public void dropCourse(Student student, Course course) {
		
		addedCourses.remove(student.getId(), course);
	}

	public void viewGrades(Student student) {
		
	}
	
	public void payFee(Student student) {
		
	}
}
