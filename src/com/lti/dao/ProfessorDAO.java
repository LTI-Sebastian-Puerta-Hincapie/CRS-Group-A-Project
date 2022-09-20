package com.lti.dao;

import com.lti.bean.Course;
import com.lti.bean.Student;

public interface ProfessorDAO {

	public void addGradesDAO(Student student, Course course);
	
	public void viewEnrolledStudentsDAO(Course course);
}
