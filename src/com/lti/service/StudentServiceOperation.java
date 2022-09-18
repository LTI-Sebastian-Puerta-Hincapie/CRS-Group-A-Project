/**
 * 
 */
package com.lti.service;

import com.lti.bean.Course;
import com.lti.bean.Student;

/**
 * @author user106
 *
 */
public interface StudentServiceOperation {
	
	public void registerForCourse(Student student, Course course);
	
	public void addCourse(Student student, Course course);
	
	public void dropCourse(Student student, Course course);
	
	public void viewGrades(Student student);
	
	public void payFee(Student student, String paymentMethod);
}
