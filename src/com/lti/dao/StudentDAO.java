/**
 * 
 */
package com.lti.dao;

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.Grade;
import com.lti.bean.Payment;
import com.lti.bean.RegisteredCourse;
import com.lti.bean.Student;

/**
 * @author Sebastian
 *
 */
public interface StudentDAO {

	/**
	 * This method registers a student for a specific course 
	 * @param Student student
	 * @param int courseId
	 */
	public void registerForCourseDAO(Student student, int courseId);
	
	/**
	 * This method adds a course for a specific student
	 * @param Student student
	 * @param int courseId
	 */
	public void addCourseDAO(Student student, int courseId);
	
	/**
	 * This method drops a course for a specific student
	 * @param Student student
	 * @param int courseId
	 */
	public void dropCourseDAO(Student student, int courseId);
	
	/**
	 * This method view grades for a specific student and returns a list of grades
	 * @param Student student
	 * @return List<Grade>
	 */
	public List<Grade> viewGradesDAO(Student student);
	
	/**
	 * This method makes a payment for the courses that the student is registered for
	 * @param Student student
	 * @param String paymentMethod
	 */
	public void payFeeDAO(Student student, String paymentMethod);
	
	/**
	 * This method gets the student data 
	 * @param int studentId
	 * @return Student student
	 */
	public Student getStudentDAO(int studentId);
	
	/**
	 * This method gets all courses for a specific student that they have added
	 * @param int studentId
	 * @return List<Course>
	 */
	public List<Course> getStudentCoursesDAO(int studentId);
	
	/**
	 * This method gets all registered courses for a specific student
	 * @param int studentId
	 * @return List<RegisteredCourse>
	 */
	public List<RegisteredCourse> getStudentRegisteredCoursesDAO(int studentId);
	
	/**
	 * This method add payment data (amount, due date, semester, etc.) to the system
	 * @param int studentId
	 * @param Payment payment
	 */
	public void generatePaymentDAO(int studentId, Payment payment);
}
