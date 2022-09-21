/**
 * 
 */
package com.lti.service;

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.CourseCatalog;
import com.lti.bean.CourseEnrollment;
import com.lti.bean.Grade;
import com.lti.bean.Professor;
import com.lti.bean.Student;

/**
 * @author Sebastian
 *
 */
public interface ProfessorServiceOperation {
	
	/**
	 * This method that add grades for a specific student 
	 * @param int studentId
	 * @param int courseId
	 * @param String grade
	 */
	public void addGrades(int studentId, int courseId, String grade);

	
	/**
	 * This method returns a list of all enrolled students in a specific course
	 * @param int courseId
	 * @return List<CourseEnrollment> 
	 */
	public List<CourseEnrollment> viewEnrolledStudents(int courseId);
	
	/**
	 * This method gets the professor data 
	 * @param int professorId
	 * @return Professor professor
	 */
	public Professor getProfessor(int professorId);
	
	/**
	 * This method gets all courses for a specific professor
	 * @param int professorId
	 * @return List<CourseCatalog>
	 */
	public List<CourseCatalog> getProfessorCourses(int professorId);
}
