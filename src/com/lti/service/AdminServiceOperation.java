/**
 * 
 */
package com.lti.service;

import com.lti.bean.Admin;
import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.bean.SemesterRegistration;
import com.lti.bean.Student;

/**
 * @author Jonathan
 *
 */
public interface AdminServiceOperation {
	
	public void generateReportCard(int studentID);
	
	public void addProfessor(Professor professor);
	
	public void approveStudentRegistration(int studentID, boolean approvalStatus);
	
	public void createStudentRegistration(SemesterRegistration semesterRegistration);
	
	public void addCourse(Course course);
	
	public void removeCourse(int id);
	
	public void updateCourse(int id, String name, String description);
	
	public void checkAvailability(int id);
	
	public void viewCourses(int studentID);
}
