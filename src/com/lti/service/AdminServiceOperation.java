/**
 * 
 */
package com.lti.service;

import com.lti.bean.Admin;
import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.bean.Student;

/**
 * @author Sebastian
 *
 */
public interface AdminServiceOperation {
	
	public void generateReportCard(Student student, Professor professor);
	
	public void addProfessor(Professor professor);
	
	public void approveStudentRegistration(Student student);
	
	public void addCourse(Course course);
	
	public void removeCourse(int id);
	
	public void updateCourse(int id, String name, String professor, String department, String prerequisites, int credits);
	
	public void checkAvailability(int id);
	
	public void viewCourses(Student student);
}
