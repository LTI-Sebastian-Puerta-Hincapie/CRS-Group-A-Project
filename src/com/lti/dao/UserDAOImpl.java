package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lti.bean.User;

/**
 * @author Sebastian 
 *
 */

public class UserDAOImpl implements UserDAO {

	// Queries
	private static final String SELECT_USER_PASSWORD_BY_USERNAME = 
			"SELECT * FROM users WHERE Username = ?";
	
	// JDBC driver name and database URL
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	final String DB_URL = "jdbc:mysql://localhost/crs-group-a";
	
	//  Database credentials
	final String USER = "root";
	final String PASS = "root";
	
	private Connection conn = null;
	private PreparedStatement stmt = null;

	@Override
	public String LoginDAO(String username) {
		
	   String password = null;
	   try {
		   
		  Class.forName("com.mysql.jdbc.Driver");			
		  conn = DriverManager.getConnection(DB_URL,USER,PASS);
		  
	      stmt = conn.prepareStatement(SELECT_USER_PASSWORD_BY_USERNAME);
	      stmt.setString(1, username);
	      ResultSet rs = stmt.executeQuery();
	      if(rs.next()) {
	    	  password = rs.getString("Password");
	      }
	
	   } catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   } catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   } finally {
	      //finally block used to close resources
		  try {
		     if(stmt!=null)
		        stmt.close();
		  } catch(SQLException se2){}// nothing we can do
		  try {
		     if(conn!=null)
		        conn.close();
		  } catch(SQLException se){
		     se.printStackTrace();
		  } 
	   } 
	   
	   return password;
	}

	@Override
	public void LogoutDAO(String username) {
		// TODO Auto-generated method stub
		
	}
}
