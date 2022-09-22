package com.lti.dao;
import java.util.List;
import com.lti.bean.Course;
import com.lti.bean.Grade;
import com.lti.bean.Student;
/**
 * @author Sebastian
 *
 */
public interface ProfessorDAO {
    /**
     * This method add grades for a specific student 
     * @param Student student
     * @param int courseId
     * @return List<Grade>     */
    public List<Grade> addGradesDAO(Student student, int courseId);
    /**
     * This method returns a list of all enrolled students in a specific course
     * @param int courseId
     * @return List<Student>     */
    public List<Student> viewEnrolledStudentsDAO(int courseId);
}