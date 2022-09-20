package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.Student;
import com.lti.utils.DBUtils;

public class StudentDAOImpl implements StudentDAO {
	
	// Queries
	private static final String INSERT_STUDENT_COURSE = 
			"INSERT INTO registeredcourse (StudentId, CourseId, RegistrationStatus, Grade) "
			+ "VALUES (?, ?, ?, ?)";
	
	private static final String SELECT_STUDENT = "SELECT * FROM students WHERE Id = ?";
	
	private static final String SELECT_STUDENT_COURSES = 
			"SELECT rc.CourseId, c.CourseName"
			+ "FROM registeredcourse rc"
			+ "JOIN course c"
			+ "  ON rc.CourseId = c.CourseId"
			+ "WHERE rc.StudentId = ?";
    
	private Connection conn = null;
	private PreparedStatement stmt = null;
   

	@Override
	public void registerForCourseDAO(Student student, Course course) {
		// TODO Auto-generated method stub
		
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
	public void dropCourseDAO(Student student, Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewGradesDAO(Student student) {
		// TODO Auto-generated method stub
		
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
			  
		      stmt = conn.prepareStatement(SELECT_STUDENT);
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
		
		List<Course> courses = null;
		   try {

			  conn = DBUtils.getConnection();
			  
		      stmt = conn.prepareStatement(SELECT_STUDENT_COURSES);
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
}
