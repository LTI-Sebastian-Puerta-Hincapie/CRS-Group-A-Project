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
public interface ProfessorServiceOperation {
	
	public void addGrades(Student student, Course course);
	
	public void viewEnrolledStudents(Course course);
}
