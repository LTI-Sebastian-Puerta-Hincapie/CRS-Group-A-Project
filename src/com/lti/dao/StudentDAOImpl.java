package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lti.bean.Course;
import com.lti.bean.Student;

public class StudentDAOImpl implements StudentDAO {
	
	// Queries
	private static final String INSERT_STUDENT_COURSE = 
			"INSERT INTO registeredcourses (StudentId, CourseId, RegistrationStatus, Grade) "
			+ "VALUES (?, ?, ?, ?)";
	
	private static final String SELECT_STUDENT = "SELECT * FROM students WHERE Id = ?";

    // JDBC driver name and database URL
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    final String DB_URL = "jdbc:mysql://localhost/crs-group-a";

    //  Database credentials
    final String USER = "root";
    final String PASS = "root";
    
	private Connection conn = null;
	private PreparedStatement stmt = null;
   

	@Override
	public void registerForCourseDAO(Student student, Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCourseDAO(Student student, Course course) {
		
		   try {
			   
			  Class.forName("com.mysql.jdbc.Driver");			
			  System.out.println("Connecting to database...");
			  conn = DriverManager.getConnection(DB_URL,USER,PASS);
			  
		      stmt = conn.prepareStatement(INSERT_STUDENT_COURSE);
		      stmt.setInt(1,student.getId());
		      stmt.setInt(2, course.getCourseId());
		      stmt.setInt(3, 0);
		      stmt.setString(4, null);
		      stmt.executeUpdate();	
		    

		   } catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   } catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   } finally{
		      //finally block used to close resources
		      try {
		         if(stmt!=null)
		            stmt.close();
		      } catch(SQLException se2){
		      }// nothing we can do
		      try {
		         if(conn!=null)
		            conn.close();
		      } catch(SQLException se){
		         se.printStackTrace();
		      } //end finally try
		   } //end try	
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
			   
			  Class.forName("com.mysql.jdbc.Driver");			
			  System.out.println("Connecting to database...");
			  conn = DriverManager.getConnection(DB_URL,USER,PASS);
			  
		      stmt = conn.prepareStatement(SELECT_STUDENT);
		      stmt.setInt(1,studentId);
		      ResultSet rs = stmt.executeQuery();
		      if(rs.next()) {
		    	  int id = rs.getInt("Id");
		    	  String name = rs.getString("Name");
		    	  int majorId = rs.getInt("MajorId");
		    	  String email = rs.getString("Email");
		    	  String phone = rs.getString("phone");
		    	  String address = rs.getString("address");
		    	  student = new Student(id, name, majorId, email, phone, address);
		      }

		   } catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   } catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   } finally{
		      //finally block used to close resources
		      try {
		         if(stmt!=null)
		            stmt.close();
		      } catch(SQLException se2){
		      }// nothing we can do
		      try {
		         if(conn!=null)
		            conn.close();
		      } catch(SQLException se){
		         se.printStackTrace();
		      } //end finally try
		   } //end try	
		   
		   return student;
	}
}
