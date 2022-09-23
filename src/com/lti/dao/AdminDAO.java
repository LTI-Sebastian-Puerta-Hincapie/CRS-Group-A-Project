/**
 * 
 */
package com.lti.dao;

import com.lti.bean.Admin;
import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.bean.SemesterRegistration;
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
	 * This method adds a professor to the database
	 * @param professor
	 */
	public void addProfessorDAO(Professor professor);
	
	/**
	 * This method approves the registration of a student's course
	 * @param int 
	 * @param int 
	 */
	public void approveStudentRegistrationDAO(int studentID, int approvalStatus);
	
	/**
	 * Creates StudentRegistration in database
	 * @param semesterRegistration
	 */
	public void createStudentRegistrationDAO(SemesterRegistration semesterRegistration);
	
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
	 * @param int id
	 * @param String name
	 * @param String description
	 */
	public void updateCourseDAO(int id, String name, String description);
	
	/**
	 * This method checks if a course is available for enrollment
	 * @param int id
	 */
	public void checkAvailabilityDAO(int id);
	
	/**
	 * This method checks the list of courses a student is registered to
	 * @param int studentID
	 */
	public void viewCourses(int studentID);
	
	/**
	 * This method checks the list of courses a student is registered to
	 * @param int studentId
	 */
	public SemesterRegistration getSemesterRegistrationDAO(int studentId);
	
}
