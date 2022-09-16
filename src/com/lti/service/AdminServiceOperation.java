/**
 * 
 */
package com.lti.service;

import com.lti.bean.Admin;
import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.bean.Student;

/**
 * @author user106
 *
 */
public interface AdminServiceOperation {
	
	public void generateReportCard(Admin admin, Student student);
	
	public void addProfessor(Professor professor);
	
	public void approveStudentRegistration(Student student);
	
	public void addCourse(Course course);
	
	public void removeCourse(int id);
	
	public void updateCourse(Course course);
	
	public void checkAvailability(Course course);
	
	public void viewCourses(Student student);
}
