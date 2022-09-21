/**
 * 
 */
package com.lti.dao;

import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.bean.Student;

/**
 * @author user106
 *
 */
public interface AdminDAO {

	public void generateReportCardDAO(Student student, Professor professor);
	public void addProfessorDAO(Professor professor);
	public void approveStudentRegistrationDAO(Student student);
	public void addCourseDAO(Course course);
	public void removeCourseDAO(int id);
	public void updateCourseDAO(int id, String name, String description);
	public void checkAvailabilityDAO(int id);
	public void viewCourses(Student student);
	
}
