/**
 * 
 */
package com.lti.service;

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.CourseCatalog;
import com.lti.bean.Grade;
import com.lti.bean.Payment;
import com.lti.bean.RegisteredCourse;
import com.lti.bean.Student;
import com.lti.exception.PaymentBillNotCreatedException;
import com.lti.exception.CourseNotFoundException;
import com.lti.exception.CourseNotRegisteredException;
import com.lti.exception.StudentAddCourseException;
import com.lti.exception.StudentCourseNotFoundException;
import com.lti.exception.StudentDropCourseException;
import com.lti.exception.StudentNotFoundException;
import com.lti.exception.StudentMissingFeePaymentException;
import com.lti.exception.StudentPaymentRecordNotFoundException;
import com.lti.exception.StudentCourseRegistrationNotFoundException;
import com.lti.exception.UnableToViewStudentGradesException;

/**
 * @author Sebastian
 *
 */
public interface StudentServiceOperation {
	
	/**
	 * This method registers a student for a specific course 
	 * @param Student student
	 * @param int courseId
	 * @exception StudentCourseRegistrationNotFoundException
	 */
	public void registerForCourse(Student student, int courseId) throws CourseNotRegisteredException, StudentCourseNotFoundException;
	
	/**
	 * This method adds a course for a specific student
	 * @param Student student
	 * @param int courseId
	 * @exception StudentAddCourseException
	 */
	public void addCourse(Student student, int courseId) throws StudentAddCourseException;
	
	/**
	 * This method gets a course for a specific student and courseId
	 * @param Student student
	 * @param int courseId
	 * @return RegisteredCourse
	 */
	public RegisteredCourse getCourse(Student student, int courseId);
	
	/**
	 * This method drops a course for a specific student
	 * @param Student student
	 * @param int courseId
	 * @exception StudentDropCourseException
	 */
	public void dropCourse(Student student, int courseId) throws StudentDropCourseException, StudentCourseNotFoundException;
	
	/**
	 * This method view grades for a specific student and returns a list of grades
	 * @param Student student
	 * @exception UnableToViewStudentGradesException
	 * @return List<Grade>
	 */
	public List<Grade> viewGrades(Student student) throws StudentCourseNotFoundException;
	
	/**
	 * This method makes a payment for the courses that the student is registered for
	 * @param Student student
	 * @param String paymentMethod
	 * @exception StudentMissingFeePaymentException, StudentPaymentRecordNotFoundException
	 */
	public void payFee(Student student, String paymentMethod) throws StudentMissingFeePaymentException, StudentPaymentRecordNotFoundException;
	
	/**
	 * This method gets the student data 
	 * @param int studentId
	 * @exception StudentNotFoundException
	 * @return Student student
	 */
	public Student getStudent(int studentId) throws StudentNotFoundException;
	
	/**
	 * This method gets all courses for a specific student that they have added
	 * @param int studentId
	 * @exception StudentCourseNotFoundException
	 * @return List<Course>
	 */
	public List<Course> getStudentCourses(int studentId) throws StudentCourseNotFoundException;
	
	/**
	 * This method gets all registered courses for a specific student
	 * @param int studentId
	 * @exception CourseNotRegisteredException
	 * @return List<RegisteredCourse>
	 */
	public List<RegisteredCourse> getStudentRegisteredCourses(int studentId) throws CourseNotRegisteredException;
	
	/**
	 * This method add payment data (amount, due date, semester, etc.) to the system
	 * @param int studentId
	 * @exception PaymentBillNotCreatedException
	 */
	public void generatePayment(int studentId) throws PaymentBillNotCreatedException;
	
	/**
	 * This method gets course data from course catalog and returns a list of courses
	 * @param int studentId
	 * @exception CourseNotRegisteredException
	 */
	public List<CourseCatalog> getRegisteredCourseData(int studentId) throws CourseNotRegisteredException;
	
	/**
	 * This method gets fee/payment due for a specific student 
	 * @param int studentId
	 * @exception StudentPaymentRecordNotFoundException
	 * @return Payment
	 */
	public Payment getFee(int studentId) throws StudentPaymentRecordNotFoundException;
	
	/**
	 * This methods adds student semester registration for admin approval
	 * @param int studentId
	 */
	public void addStudentSemesterRegistration(int studentId);
}
