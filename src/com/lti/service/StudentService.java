package com.lti.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lti.bean.Course;
import com.lti.bean.CourseCatalog;
import com.lti.bean.Grade;
import com.lti.bean.Payment;
import com.lti.bean.RegisteredCourse;
import com.lti.bean.Student;
import com.lti.dao.StudentDAO;
import com.lti.dao.StudentDAOImpl;

/**
 * @author Sebastian
 *
 */

// TODO define all services method based on the use case diagram
public class StudentService implements StudentServiceOperation {
	
	private StudentDAO studentDao;
	
	public StudentService() {
		
		studentDao = new StudentDAOImpl();
	}
	
	public void registerForCourse(Student student, int courseId) {
		
		studentDao.registerForCourseDAO(student, courseId);
	}
	
	public void addCourse(Student student, int courseId) {
		
		studentDao.addCourseDAO(student, courseId);
	}
	
	public void dropCourse(Student student, int courseId) {
		
		studentDao.dropCourseDAO(student, courseId);
	}

	public List<Grade> viewGrades(Student student) {
		
		return studentDao.viewGradesDAO(student);
	}
	
	public void payFee(Student student, String paymentMethod) {
		
		System.out.println("\nYou have opted to pay: " + paymentMethod);
		studentDao.payFeeDAO(student, paymentMethod);
	}
	
	@Override
	public Student getStudent(int studentId) {
		
		return studentDao.getStudentDAO(studentId);
	}

	@Override
	public List<Course> getStudentCourses(int studentId) {

		return studentDao.getStudentCoursesDAO(studentId);
	}

	@Override
	public List<RegisteredCourse> getStudentRegisteredCourses(int studentId) {
		
		return studentDao.getStudentRegisteredCoursesDAO(studentId);
	}

	@Override
	public void generatePayment(int studentId) {
		
		List<CourseCatalog> courses = getRegisteredCourseData(studentId);
		int totalCredits = 0;
		int COST_PER_CREDIT = 1125;
		
		for(CourseCatalog course : courses) {
			
			totalCredits += course.getCredits();
		}
		
		int amount = COST_PER_CREDIT * totalCredits;
		Payment payment = new Payment(studentId, amount, LocalDate.now().plusDays(30), "Fall 2022");
		studentDao.generatePaymentDAO(studentId, payment);
	}

	@Override
	public List<CourseCatalog> getRegisteredCourseData(int studentId) {
		
		return studentDao.getRegisteredCourseDataDAO(studentId);
	}

	@Override
	public Payment getFee(int studentId) {
		
		return studentDao.getFeeDAO(studentId);
	}

	@Override
	public void addStudentSemesterRegistration(int studentId) {
		
		studentDao.addStudentSemesterRegistrationDAO(studentId);
	}
}
