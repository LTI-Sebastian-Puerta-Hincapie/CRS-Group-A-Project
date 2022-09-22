package com.lti.service;

import java.util.ArrayList;
import java.util.HashMap;
import com.lti.bean.Admin;
import com.lti.bean.Course;
import com.lti.bean.CourseCatalog;
import com.lti.bean.Professor;
import com.lti.bean.Student;
import com.lti.bean.SemesterRegistration;
import com.lti.dao.AdminDAO;
import com.lti.dao.AdminDAOImpl;

/**
 * @author Sebastian
 *
 */

public class AdminService implements AdminServiceOperation {

	private AdminDAO admindao;
	
	public AdminService() {
		admindao = new AdminDAOImpl();
	}

	public void generateReportCard(int studentID) {
		admindao.generateReportCardDAO(studentID);
	}
	
	public void addProfessor(Professor professor) {
		admindao.addProfessorDAO(professor);
	}
	
	public void approveStudentRegistration(SemesterRegistration semesterRegistration) {
		admindao.approveStudentRegistrationDAO(semesterRegistration);
		}
	
	public void addCourse(Course course) {
		admindao.addCourseDAO(course);
	}
	
	public void removeCourse(int id) {
		admindao.removeCourseDAO(id);
	}
	
	public void updateCourse(int id, String name, String description) {
		admindao.updateCourseDAO(id, name, description); 
	}
	
	public void checkAvailability(int id) {
		admindao.checkAvailabilityDAO(id);
	}
	
	public void viewCourses(int studentID) {
		admindao.viewCourses(studentID);
	}

	@Override
	public void approveStudentRegistration(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approveStudentRegistration(com.lti.service.SemesterRegistration semesterRegistration) {
		// TODO Auto-generated method stub
		
	}
}
