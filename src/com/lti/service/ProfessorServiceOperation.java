package com.lti.service;
<<<<<<< HEAD
import java.util.List;
import com.lti.bean.Course;
import com.lti.bean.Grade;
=======

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.CourseCatalog;
import com.lti.bean.CourseEnrollment;
import com.lti.bean.Grade;
import com.lti.bean.Professor;
>>>>>>> 9b720b09ee54245a20958640a76863f72f18a64c
import com.lti.bean.Student;
/**
 * @author Sebastian
 *
 */
public interface ProfessorServiceOperation {
<<<<<<< HEAD
    /**
     * This method that add grades for a specific student 
     * @param Student student
     * @param int courseId
     * @return List<Grade>     */
    public List<Grade> addGrades(Student student, int courseId);
    /**
     * This method returns a list of all enrolled students in a specific course
     * @param int courseId
     * @return List<Student>     */
    public List<Student> viewEnrolledStudents(int courseId);
}
=======
	
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
>>>>>>> 9b720b09ee54245a20958640a76863f72f18a64c
