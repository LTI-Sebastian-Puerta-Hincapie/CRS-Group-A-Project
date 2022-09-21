package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.Grade;
import com.lti.bean.RegisteredCourse;
import com.lti.bean.Student;
import com.lti.utils.DBUtils;

public class StudentDAOImpl implements StudentDAO {
	
	// Queries
	private static final String INSERT_STUDENT_COURSE = 
			"INSERT INTO registeredcourse (StudentId, CourseId, RegistrationStatus, Grade) "
			+ "VALUES (?, ?, ?, ?)";
	
	private static final String SELECT_STUDENT_BY_STUDENTID = "SELECT * FROM students WHERE Id = ?";
	
	private static final String SELECT_STUDENT_COURSES_BY_STUDENTID = 
			"SELECT rc.CourseId, c.CourseName "
			+ "FROM registeredcourse rc "
			+ "JOIN course c "
			+ "  ON rc.CourseId = c.CourseId "
			+ "WHERE rc.StudentId = ?";
	
	private static final String DELETE_STUDENT_COURSE_BY_COURSEID_AND_STUDENTID = 
			"DELETE FROM registeredcourse WHERE StudentId = ? AND CourseId = ?";
	
	private static final String SELECT_GRADES_BY_STUDENTID = 
			"SELECT rc.CourseId, c.CourseName, rc.Grade "
			+ "FROM registeredcourse rc "
			+ "JOIN course c "
			+ "ON rc.CourseId = c.CourseId "
			+ "WHERE rc.StudentId = ?";
	
	private static final String UPDATE_REGISTRATION_BY_COURSEID_AND_STUDENTID = 
			"UPDATE registeredcourse SET RegistrationStatus = 1 WHERE StudentId = ? AND CourseId = ?";
	
	private static final String SELECT_STUDENT_REGISTERED_COURSES_BY_STUDENTID = 
			"SELECT * FROM registeredcourse WHERE StudentId = ? AND RegistrationStatus = 1";
	  
	private Connection conn = null;
	private PreparedStatement stmt = null;
   

	@Override
	public void registerForCourseDAO(Student student, int courseId) {
		
	   try {

		  conn = DBUtils.getConnection();
		  
	      stmt = conn.prepareStatement(UPDATE_REGISTRATION_BY_COURSEID_AND_STUDENTID);
	      stmt.setInt(1,student.getId());
	      stmt.setInt(2, courseId);
	      stmt.executeUpdate();

	   } catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   } catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }
	}

	@Override
	public void addCourseDAO(Student student, int courseId) {
		
	   try {
		   
		  conn = DBUtils.getConnection();
		  
	      stmt = conn.prepareStatement(INSERT_STUDENT_COURSE);
	      stmt.setInt(1,student.getId());
	      stmt.setInt(2, courseId);
	      stmt.setInt(3, 0);
	      stmt.setString(4, null);
	      stmt.executeUpdate();	
	    
	   } catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   } catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   } 	
	}

	@Override
	public void dropCourseDAO(Student student, int courseId) {
		
	   try {

		  conn = DBUtils.getConnection();
		  
	      stmt = conn.prepareStatement(DELETE_STUDENT_COURSE_BY_COURSEID_AND_STUDENTID);
	      stmt.setInt(1,student.getId());
	      stmt.setInt(2, courseId);
	      stmt.executeUpdate();

	   } catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   } catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }		
	}

	@Override
	public List<Grade> viewGradesDAO(Student student) {
		
		List<Grade> grades = new ArrayList<Grade>();
		Grade grade = null;
		Course course = null;
		   try {

			  conn = DBUtils.getConnection();
			  
		      stmt = conn.prepareStatement(SELECT_GRADES_BY_STUDENTID);
		      stmt.setInt(1,student.getId());
		      ResultSet rs = stmt.executeQuery();
		      while(rs.next()) {
		    	  int id = rs.getInt("CourseId");
		    	  String name = rs.getString("CourseName");
		    	  String _grade = rs.getString("Grade");
		    	  
		    	  course = new Course(id, name, null);
		    	  grade = new Grade(_grade, course);
		    	  grades.add(grade);
		      }

		   } catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   } catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
		   
		   return grades;
	}

	@Override
	public void payFeeDAO(Student student, String paymentMethod) {
		// TODO Auto-generated method stub
		
	}	   
	
	@Override
	public Student getStudentDAO(int studentId) {
		
		Student student = null;
		   try {

			  conn = DBUtils.getConnection();
			  
		      stmt = conn.prepareStatement(SELECT_STUDENT_BY_STUDENTID);
		      stmt.setInt(1,studentId);
		      ResultSet rs = stmt.executeQuery();
		      if(rs.next()) {
		    	  int id = rs.getInt("Id");
		    	  String name = rs.getString("Name");
		    	  int majorId = rs.getInt("MajorId");
		    	  String email = rs.getString("Email");
		    	  String phone = rs.getString("Phone");
		    	  String address = rs.getString("Address");
		    	  student = new Student(id, name, majorId, email, phone, address);
		      }

		   } catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   } catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
		   
		   return student;
	}

	@Override
	public List<Course> getStudentCoursesDAO(int studentId) {
		
		List<Course> courses = new ArrayList<Course>();
		   try {

			  conn = DBUtils.getConnection();
			  
		      stmt = conn.prepareStatement(SELECT_STUDENT_COURSES_BY_STUDENTID);
		      stmt.setInt(1,studentId);
		      ResultSet rs = stmt.executeQuery();
		      while(rs.next()) {
		    	  int id = rs.getInt("CourseId");
		    	  String name = rs.getString("CourseName");
		    	  courses.add(new Course(id, name, null));
		      }

		   } catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   } catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
		   
		   return courses;
	}

	@Override
	public List<RegisteredCourse> getStudentRegisteredCoursesDAO(int studentId) {
		
		List<RegisteredCourse> rcourses = new ArrayList<RegisteredCourse>();
		
		   try {

			  conn = DBUtils.getConnection();
			  
		      stmt = conn.prepareStatement(SELECT_STUDENT_REGISTERED_COURSES_BY_STUDENTID);
		      stmt.setInt(1,studentId);
		      ResultSet rs = stmt.executeQuery();
		      while(rs.next()) {
		    	  
		    	  int courseId = rs.getInt("CourseId");
		    	  int _studentId = rs.getInt("StudentId");
		    	  int registrationStatus = rs.getInt("RegistrationStatus");
		    	  String grade = rs.getString("Grade");
		    	  rcourses.add(new RegisteredCourse(courseId, _studentId, registrationStatus, grade));
		      }

		   } catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   } catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
		   
		   return rcourses;
	}
}
