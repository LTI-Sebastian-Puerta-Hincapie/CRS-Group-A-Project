package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.bean.Admin;
import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.bean.RegisteredCourse;
import com.lti.bean.Student;
import com.lti.constant.SQLQueries;
import com.lti.utils.DBUtils;

public class AdminDAOImpl implements AdminDAO{
    
    private Connection conn = null;
	private PreparedStatement stmt = null;
	
	@Override
	public void generateReportCardDAO(int StudentID) {

		try{
			System.out.println("Grades for student " + StudentID + ":");
			conn = DBUtils.getConnection();
			String sql = SQLQueries.SELECT_GRADES_BY_STUDENTID;
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, StudentID);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				int courseID = rs.getInt("CourseID");
				String courseName = rs.getString("CourseName");
				String grade = rs.getString("Grade");
				
				System.out.println(courseID + " | " + courseName + ": " + grade);
			}
			
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void addProfessorDAO(Professor professor) {
		try{
			conn = DBUtils.getConnection();
			String sql="insert into professors values(?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);

			int id=professor.getId();
			String name=professor.getName();
			int departmentID=professor.getDepartmentId();
			String email=professor.getEmail();
			String phone=professor.getPhone();
			String address=professor.getAddress();

			stmt.setInt(1, id);
			stmt.setString(2,name);
			stmt.setInt(3, departmentID);
			stmt.setString(4, email);
			stmt.setString(5, phone);
			stmt.setString(6, address);
			stmt.executeUpdate();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void approveStudentRegistrationDAO(Student student, Admin admin) {/*
		try{
			conn = DBUtils.getConnection();
			String sql="insert into semesterregistration values(?.?,?,?,?)";
			stmt = conn.prepareStatement(sql);

			int id=student.getId();
			Boolean approvalStatus=true;
			String description =course.getDescription();

			stmt.setInt(1, id);  // This would set age
			stmt.setString(2,name);
			stmt.setString(3, description);
			stmt.executeUpdate();
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}*/
	}

	@Override
	public void addCourseDAO(Course course) {
		try{
			conn = DBUtils.getConnection();
			String sql="insert into course values(?,?,?)";
			stmt = conn.prepareStatement(sql);

			int id=course.getCourseId();
			String name=course.getCourseName();
			String description =course.getDescription();

			stmt.setInt(1, id);
			stmt.setString(2,name);
			stmt.setString(3, description);
			stmt.executeUpdate();
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
	}
	

	@Override
	public void removeCourseDAO(int id) {
		try{
			conn = DBUtils.getConnection();
			String sql="DELETE from course where CourseID=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
	}

	@Override
	public void updateCourseDAO(int id, String name, String description) {
		try{
			conn = DBUtils.getConnection();
			String sql = "UPDATE course SET CourseName=?, Description=? WHERE CourseID=?";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1,name);
			stmt.setString(2, description);
			stmt.setInt(3, id);
			stmt.executeUpdate();
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}   
	}

	@Override
	public void checkAvailabilityDAO(int id) {
		try{
			conn = DBUtils.getConnection();
			String sql = "SELECT Capacity, Enrolled From coursecatalog WHERE Id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				if(rs.getInt("Enrolled") < rs.getInt("Capacity")) {
					System.out.println("Course is available");
				}
				else {
					System.out.println("Course is full");
				}
			}
			else {
				System.out.println("Course is not being offered");
			}	
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		} 
	}

	@Override
	public void viewCourses(int studentID) {
		
		System.out.println("Student " + studentID + " is registered for the following courses:");
		   try {

			  conn = DBUtils.getConnection();
			  
		      stmt = conn.prepareStatement(SQLQueries.SELECT_STUDENT_COURSES_BY_STUDENTID);
		      stmt.setInt(1,studentID);
		      ResultSet rs = stmt.executeQuery();
		      while(rs.next()) {
		    	  int courseId = rs.getInt("CourseId");
		    	  String courseName = rs.getString("CourseName");
		    	  System.out.println(courseId + ": " + courseName);
		      }

		   } catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   } catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
	}

}
