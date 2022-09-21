package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	
	public static Connection connectDatabase() throws SQLException, ClassNotFoundException {
		Connection con= null;
		 try {
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/crs_group_a","root","root"); 
		 }catch(Exception e) {
			 System.out.println("An error occurred while connecting to database");
		 }
		
			return con;
			
			
			/*
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from students");  
			
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4));  
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
			*/
			}
	
	public static void main(String[] args) {
		System.out.println("starting");
		//connectDatabase();
		System.out.println("completed");
	}
	
	}
