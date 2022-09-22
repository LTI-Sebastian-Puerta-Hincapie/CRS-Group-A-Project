package com.lti.service;
<<<<<<< HEAD
import java.util.List;
import com.lti.bean.Course;
import com.lti.bean.Grade;
import com.lti.bean.Student;
=======

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.CourseCatalog;
import com.lti.bean.CourseEnrollment;
import com.lti.bean.Grade;
import com.lti.bean.Professor;
import com.lti.bean.Student;
import com.lti.dao.ProfessorDAO;
import com.lti.dao.ProfessorDAOImpl;

>>>>>>> 9b720b09ee54245a20958640a76863f72f18a64c
/**
 * @author Sebastian
 *
 */
<<<<<<< HEAD
public class ProfessorService implements ProfessorServiceOperation {
	
	
    public List<Grade> addGrades(Student student, int courseId) {
        // TODO
        return null;
    }
    public List<Student> viewEnrolledStudents(int courserId) {
        // TODO
        return null;
    }
}
=======

public class ProfessorService implements ProfessorServiceOperation {
	
	private ProfessorDAO professorDao;
	
	public ProfessorService() {
		
		this.professorDao = new ProfessorDAOImpl();
	}
	
	public void addGrades(int studentId, int courseId, String grade) {
		
		professorDao.addGradesDAO(studentId, courseId, grade);
	}
	
	public List<CourseEnrollment> viewEnrolledStudents(int courserId) {
		
		return professorDao.viewEnrolledStudentsDAO(courserId);
	}

	@Override
	public Professor getProfessor(int professorId) {

		return professorDao.getProfessorDAO(professorId);
	}

	@Override
	public List<CourseCatalog> getProfessorCourses(int professorId) {

		return professorDao.getProfessorCoursesDAO(professorId);
	}
}
>>>>>>> 9b720b09ee54245a20958640a76863f72f18a64c
