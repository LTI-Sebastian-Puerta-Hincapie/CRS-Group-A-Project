package com.lti.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lti.bean.Course;
import com.lti.bean.Payment;
import com.lti.bean.Student;
import com.lti.dao.StudentDAO;
import com.lti.dao.StudentDAOImpl;

// TODO define all services method based on the use case diagram
public class StudentService implements StudentServiceOperation {
	
	private StudentDAO studentDao;
	
	public StudentService() {
		
		studentDao = new StudentDAOImpl();
	}
	
	public void registerForCourse(Student student, Course course) {
		
		studentDao.registerForCourseDAO(student, course);
	}
	
	public void addCourse(Student student, int courseId) {
		
		studentDao.addCourseDAO(student, courseId);
	}
	
	public void dropCourse(Student student, Course course) {
		
		studentDao.dropCourseDAO(student, course);
	}

	public void viewGrades(Student student) {
		
		System.out.println("\nNo grades have been entered, please comeback at a later time");
	}
	
	public void payFee(Student student, String paymentMethod) {
		
		System.out.println("\nYou have opted to pay: " + paymentMethod);
	}
	
	@Override
	public Student getStudent(int studentId) {
		
		return studentDao.getStudentDAO(studentId);
	}

	@Override
	public List<Course> getStudentCourses(int studentId) {

		return studentDao.getStudentCoursesDAO(studentId);
	}
	
	
}
