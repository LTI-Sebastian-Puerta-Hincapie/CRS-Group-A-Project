/**
 * 
 */
package com.lti.dao;

import com.lti.bean.Admin;
import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.bean.Student;

/**
 * @author Jonathan
 *
 */
public interface AdminDAO {

	/**
	 * This method generates a report card for the student
	 * @param StudentID
	 */
	public void generateReportCardDAO(int StudentID);
	
	/**
	 * THis method adds a professor to the database
	 * @param professor
	 */
	public void addProfessorDAO(Professor professor);
	
	/**
	 * This method approves the registration of a student's course
	 * @param student
	 * @param admin
	 */
	public void approveStudentRegistrationDAO(Student student, Admin admin);
	
	/**
	 * This method adds a course to the course list
	 * @param course
	 */
	public void addCourseDAO(Course course);
	
	/**
	 * This method removes the course from the course list
	 * @param id
	 */
	public void removeCourseDAO(int id);
	
	/**
	 * This method updates a course's information in the course list
	 * @param id
	 * @param name
	 * @param description
	 */
	public void updateCourseDAO(int id, String name, String description);
	
	/**
	 * This method checks if a course is available for enrollment
	 * @param id
	 */
	public void checkAvailabilityDAO(int id);
	
	/**
	 * This method checks the list of courses a student is registered to
	 * @param studentID
	 */
	public void viewCourses(int studentID);
	
}
