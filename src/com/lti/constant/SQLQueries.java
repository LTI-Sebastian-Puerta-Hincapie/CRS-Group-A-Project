package com.lti.constant;

public class SQLQueries {

	// USER
	public static final String SELECT_USER_BY_USERNAME = 
			"SELECT * FROM users WHERE Username = ?";
	
	// STUDENT
	public static final String INSERT_STUDENT_COURSE = 
			"INSERT INTO registeredcourse (StudentId, CourseId, RegistrationStatus, Grade) "
			+ "VALUES (?, ?, ?, ?)";
	
	public static final String SELECT_STUDENT_BY_STUDENTID = "SELECT * FROM students WHERE Id = ?";
	
	public static final String SELECT_STUDENT_COURSES_BY_STUDENTID = 
			"SELECT rc.CourseId, c.CourseName "
			+ "FROM registeredcourse rc "
			+ "JOIN course c "
			+ "  ON rc.CourseId = c.CourseId "
			+ "WHERE rc.StudentId = ?";
	
	public static final String DELETE_STUDENT_COURSE_BY_COURSEID_AND_STUDENTID = 
			"DELETE FROM registeredcourse WHERE StudentId = ? AND CourseId = ?";
	
	public static final String SELECT_GRADES_BY_STUDENTID = 
			"SELECT rc.CourseId, c.CourseName, rc.Grade "
			+ "FROM registeredcourse rc "
			+ "JOIN course c "
			+ "ON rc.CourseId = c.CourseId "
			+ "WHERE rc.StudentId = ?";
	
	public static final String UPDATE_REGISTRATION_BY_COURSEID_AND_STUDENTID = 
			"UPDATE registeredcourse SET RegistrationStatus = 1 WHERE StudentId = ? AND CourseId = ?";
	
	public static final String SELECT_STUDENT_REGISTERED_COURSES_BY_STUDENTID = 
			"SELECT * FROM registeredcourse WHERE StudentId = ? AND RegistrationStatus = 1";
	
	// PROFESSOR
	public static final String UPDATE_STUDENT_GRADE_BY_STUDENTID_AND_COURSEID = 
			"UPDATE registeredcourse SET Grade = ? WHERE StudentId = ? AND CourseId = ?";
	
	public static final String SELECT_PROFESSOR_COURSES_BY_PROFESSORID = 
			"SELECT pc.CourseId, cc.Credits, cc.Capacity, cc.Enrolled, cc.Semester "
			+ "FROM professorcourses pc "
			+ "JOIN coursecatalog cc "
			+ " ON pc.CourseId = cc.Id "
			+ "WHERE pc.ProfessorId = ?";
	
	public static final String SELECT_PROFESSOR_BY_PROFESSORID = 
			"SELECT * FROM professors WHERE Id = ?";
	
	public static final String SELECT_STUDENT_ENROLLMENT_BY_COURSEID = 
			"SELECT pc.CourseId, rc.StudentId, s.Name "
			+ "FROM professorcourses pc "
			+ "JOIN registeredcourse rc "
			+ " ON pc.CourseId = rc.CourseId "
			+ "JOIN students s "
			+ " ON rc.StudentId = s.Id "
			+ "WHERE pc.CourseId = ?";
	
	
	// ADMIN
}
