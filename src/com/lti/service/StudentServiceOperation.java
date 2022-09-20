/**
 * 
 */
package com.lti.service;

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.Student;

/**
 * @author Sebastian
 *
 */
public interface StudentServiceOperation {
	
	public void registerForCourse(Student student, Course course);
	
	public void addCourse(Student student, int courseId);
	
	public void dropCourse(Student student, Course course);
	
	public void viewGrades(Student student);
	
	public void payFee(Student student, String paymentMethod);
	
	public Student getStudent(int studentId);
	
	public List<Course> getStudentCourses(int studentId);
}
