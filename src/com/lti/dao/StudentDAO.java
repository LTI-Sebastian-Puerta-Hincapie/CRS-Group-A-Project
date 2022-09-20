/**
 * 
 */
package com.lti.dao;

import com.lti.bean.Course;
import com.lti.bean.Student;

/**
 * @author user106
 *
 */
public interface StudentDAO {

	public void registerForCourseDAO(Student student, Course course);
	
	public void addCourseDAO(Student student, Course course);
	
	public void dropCourseDAO(Student student, Course course);
	
	public void viewGradesDAO(Student student);
	
	public void payFeeDAO(Student student, String paymentMethod);
}
