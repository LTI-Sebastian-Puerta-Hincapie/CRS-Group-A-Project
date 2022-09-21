/**
 * 
 */
package com.lti.service;

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.Grade;
import com.lti.bean.RegisteredCourse;
import com.lti.bean.Student;

/**
 * @author Sebastian
 *
 */
public interface StudentServiceOperation {
	
	public void registerForCourse(Student student, int courseId);
	
	public void addCourse(Student student, int courseId);
	
	public void dropCourse(Student student, int courseId);
	
	public List<Grade> viewGrades(Student student);
	
	public void payFee(Student student, String paymentMethod);
	
	public Student getStudent(int studentId);
	
	public List<Course> getStudentCourses(int studentId);
	
	public List<RegisteredCourse> getStudentRegisteredCourses(int studentId);
}
