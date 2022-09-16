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
	
	public void registerForCourse(Student student, Course course, Boolean register);
	
	public void addCourse(Student student, Course course);
	
	public void dropCourse(Student student, int id);
	
	public void viewGrades(Student student);
	
	public void payFee(Student student);
}
