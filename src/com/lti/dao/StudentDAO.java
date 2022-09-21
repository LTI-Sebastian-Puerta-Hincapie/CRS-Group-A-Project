/**
 * 
 */
package com.lti.dao;

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.Grade;
import com.lti.bean.RegisteredCourse;
import com.lti.bean.Student;

/**
 * @author Sebastian
 *
 */
public interface StudentDAO {

	public void registerForCourseDAO(Student student, int courseId);
	
	public void addCourseDAO(Student student, int courseId);
	
	public void dropCourseDAO(Student student, int courseId);
	
	public List<Grade> viewGradesDAO(Student student);
	
	public void payFeeDAO(Student student, String paymentMethod);
	
	public Student getStudentDAO(int studentId);
	
	public List<Course> getStudentCoursesDAO(int studentId);
	
	public List<RegisteredCourse> getStudentRegisteredCoursesDAO(int studentId);
}
