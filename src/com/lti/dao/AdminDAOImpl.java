package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.bean.Student;

public class AdminDAOImpl implements AdminDAO{

	// Step 1
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/test";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";
	
	@Override
	public void generateReportCardDAO(int StudentID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			   // Step 3 Regiater Driver here and create connection 
			   
			   Class.forName("com.mysql.jdbc.Driver");

			   // Step 4 make/open  a connection 
			   
			      System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			      //STEP 4: Execute a query
			      System.out.println("Creating statement...");
			      /*
			      //String sql="insert into professors values(?,?,?)";
			      //String sql = "UPDATE Employees set age=? WHERE id=?";
			     // String sql1="delete from employee where id=?";
			     // stmt.setInt(1, 101);
			      stmt = conn.prepareStatement(sql);
			   
			      // Hard coded data 
			      
			      int id=professor.getId();
			      String name=professor.getName();
			      int departmentID=professor.getDepartmentId();
			      //Bind values into the parameters.
			      stmt.setInt(1, id);  // This would set age
			      stmt.setString(2,name);
			      stmt.setInt(3, departmentID);
			      stmt.executeUpdate();
			           */
			   
			   
			   
			   // Let us update age of the record with ID = 102;
			      //int rows = stmt.executeUpdate();
			      //System.out.println("Rows impacted : " + rows );

			      // Let us select all the records and display them.
			      sql = "SELECT CourseID, grade FROM registeredcourse WHERE StudentID=?";
			      ResultSet rs = stmt.executeQuery(sql);

			      //STEP 5: Extract data from result set
			      while(rs.next()){
			         //Retrieve by column name
			         int eid  = rs.getInt("id");
			         String name1 = rs.getString("name");
			         String address1 = rs.getString("address");
			         String location1 = rs.getString("location");

			         //Display values
			         System.out.print("ID: " + eid);
			         System.out.print(", Age: " + name1);
			         System.out.print(", First: " + address1);
			         System.out.println(", Last: " + location1);
			      }
			      //STEP 6: Clean-up environment
			     // rs.close();
			      stmt.close();
			      conn.close();
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){
			      }// nothing we can do
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
			   System.out.println("Goodbye!");
	}

	@Override
	public void addProfessorDAO(Professor professor) {
		// TODO Auto-generated method stub
		// Step 2 
				// Declare the Coneection or prepaidstatement variable here 
				   Connection conn = null;
				   PreparedStatement stmt = null;
				   
				   try{
					   
					   // Step 3 Regiater Driver here and create connection 
					   
					   Class.forName("com.mysql.jdbc.Driver");

					   // Step 4 make/open  a connection 
					   
					      System.out.println("Connecting to database...");
					      conn = DriverManager.getConnection(DB_URL,USER,PASS);
					   
					      //STEP 4: Execute a query
					      System.out.println("Creating statement...");
					      String sql="insert into professors values(?,?,?)";
					      //String sql = "UPDATE Employees set age=? WHERE id=?";
					     // String sql1="delete from employee where id=?";
					     // stmt.setInt(1, 101);
					      stmt = conn.prepareStatement(sql);
					   
					      // Hard coded data 
					      
					      int id=professor.getId();
					      String name=professor.getName();
					      int departmentID=professor.getDepartmentId();
					      //Bind values into the parameters.
					      stmt.setInt(1, id);  // This would set age
					      stmt.setString(2,name);
					      stmt.setInt(3, departmentID);
					      stmt.executeUpdate();
					           
					   
					   /*
					   
					   // Let us update age of the record with ID = 102;
					      int rows = stmt.executeUpdate();
					      System.out.println("Rows impacted : " + rows );

					      // Let us select all the records and display them.
					      sql = "SELECT id, name ,address, location FROM employeefc";
					      ResultSet rs = stmt.executeQuery(sql);

					      //STEP 5: Extract data from result set
					      while(rs.next()){
					         //Retrieve by column name
					         int eid  = rs.getInt("id");
					         String name1 = rs.getString("name");
					         String address1 = rs.getString("address");
					         String location1 = rs.getString("location");

					         //Display values
					         System.out.print("ID: " + eid);
					         System.out.print(", Age: " + name1);
					         System.out.print(", First: " + address1);
					         System.out.println(", Last: " + location1);
					      }*/
					      //STEP 6: Clean-up environment
					     // rs.close();
					      stmt.close();
					      conn.close();
					   }catch(SQLException se){
					      //Handle errors for JDBC
					      se.printStackTrace();
					   }catch(Exception e){
					      //Handle errors for Class.forName
					      e.printStackTrace();
					   }finally{
					      //finally block used to close resources
					      try{
					         if(stmt!=null)
					            stmt.close();
					      }catch(SQLException se2){
					      }// nothing we can do
					      try{
					         if(conn!=null)
					            conn.close();
					      }catch(SQLException se){
					         se.printStackTrace();
					      }//end finally try
					   }//end try
					   System.out.println("Goodbye!");
					}//end main
	

	@Override
	public void approveStudentRegistrationDAO(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCourseDAO(Course course) {
		// TODO Auto-generated method stub
		Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			   // Step 3 Regiater Driver here and create connection 
			   
			   Class.forName("com.mysql.jdbc.Driver");

			   // Step 4 make/open  a connection 
			   
			      System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			      //STEP 4: Execute a query
			      System.out.println("Creating statement...");
			      String sql="insert into course values(?,?,?,?,?,?)";
			      //String sql = "UPDATE Employees set age=? WHERE id=?";
			     // String sql1="delete from employee where id=?";
			     // stmt.setInt(1, 101);
			      stmt = conn.prepareStatement(sql);
			   
			      // Hard coded data 
			      
			      int id=course.getCourseId();
			      String name=course.getCourseName();
			      String description =course.getDescription();
			      
			      //Bind values into the parameters.
			      stmt.setInt(1, id);  // This would set age
			      stmt.setString(2,name);
			      stmt.setString(3, description);
			      stmt.executeUpdate();
			           
			   
			   /*
			   
			   // Let us update age of the record with ID = 102;
			      int rows = stmt.executeUpdate();
			      System.out.println("Rows impacted : " + rows );

			      // Let us select all the records and display them.
			      sql = "SELECT id, name ,address, location FROM employeefc";
			      ResultSet rs = stmt.executeQuery(sql);

			      //STEP 5: Extract data from result set
			      while(rs.next()){
			         //Retrieve by column name
			         int eid  = rs.getInt("id");
			         String name1 = rs.getString("name");
			         String address1 = rs.getString("address");
			         String location1 = rs.getString("location");

			         //Display values
			         System.out.print("ID: " + eid);
			         System.out.print(", Age: " + name1);
			         System.out.print(", First: " + address1);
			         System.out.println(", Last: " + location1);
			      }*/
			      //STEP 6: Clean-up environment
			     // rs.close();
			      stmt.close();
			      conn.close();
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){
			      }// nothing we can do
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
			   System.out.println("Goodbye!");
			}//end main
	

	@Override
	public void removeCourseDAO(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			   // Step 3 Regiater Driver here and create connection 
			   
			   Class.forName("com.mysql.jdbc.Driver");

			   // Step 4 make/open  a connection 
			   
			      System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   
			      //STEP 4: Execute a query
			      System.out.println("Creating statement...");
			      //String sql="insert into CourseCatalog values(?,?,?,?,?,?)";
			      //String sql = "UPDATE Employees set age=? WHERE id=?";
			      String sql="delete from course where id=?";
			     // stmt.setInt(1, 101);
			      stmt = conn.prepareStatement(sql);
			   
			      // Hard coded data 
			      
			      /*
			      String name="Calculus I";
			      int professorID =627;
			      int departmentID = 32;
			      String prerequisites = "Pre-Calculus";
			      int credits = 3;
			      */
			      //Bind values into the parameters.
			      
			      stmt.setInt(1, id);
			      /*
			      stmt.setString(2,name);
			      stmt.setInt(3, professorID);
			      stmt.setInt(4, departmentID);
			      stmt.setString(5, prerequisites);
			      stmt.setInt(6, credits);
			      */
			      stmt.executeUpdate();
			      
			   
			   /*
			   
			   // Let us update age of the record with ID = 102;
			      int rows = stmt.executeUpdate();
			      System.out.println("Rows impacted : " + rows );

			      // Let us select all the records and display them.
			      sql = "SELECT id, name ,address, location FROM employeefc";
			      ResultSet rs = stmt.executeQuery(sql);

			      //STEP 5: Extract data from result set
			      while(rs.next()){
			         //Retrieve by column name
			         int eid  = rs.getInt("id");
			         String name1 = rs.getString("name");
			         String address1 = rs.getString("address");
			         String location1 = rs.getString("location");

			         //Display values
			         System.out.print("ID: " + eid);
			         System.out.print(", Age: " + name1);
			         System.out.print(", First: " + address1);
			         System.out.println(", Last: " + location1);
			      }*/
			      //STEP 6: Clean-up environment
			     // rs.close();
			      stmt.close();
			      conn.close();
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){
			      }// nothing we can do
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
			   System.out.println("Goodbye!");
			}//end main
	
	

	@Override
	public void updateCourseDAO(int id, String name, String description) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Connection conn = null;
				   PreparedStatement stmt = null;
				   
				   try{
					   
					   // Step 3 Regiater Driver here and create connection 
					   
					   Class.forName("com.mysql.jdbc.Driver");

					   // Step 4 make/open  a connection 
					   
					      System.out.println("Connecting to database...");
					      conn = DriverManager.getConnection(DB_URL,USER,PASS);
					   
					      //STEP 4: Execute a query
					      System.out.println("Creating statement...");
					      //String sql="insert into CourseCatalog values(?,?,?,?,?,?)";
					      String sql = "UPDATE course set CourseName=? WHERE CourseID=?";
					      //String sql="delete from CourseCatalog where id=?";
					     // stmt.setInt(1, 101);
					      stmt = conn.prepareStatement(sql);
					   
					      // Hard coded data 
					      
					      /*
					      String name="Calculus I";
					      int professorID =627;
					      int departmentID = 32;
					      String prerequisites = "Pre-Calculus";
					      int credits = 3;
					      */
					      //Bind values into the parameters.
					      
					      stmt.setInt(1, id);
					      /*
					      stmt.setString(2,name);
					      stmt.setInt(3, professorID);
					      stmt.setInt(4, departmentID);
					      stmt.setString(5, prerequisites);
					      stmt.setInt(6, credits);
					      */
					      stmt.executeUpdate();
					      
					   
					   /*
					   
					   // Let us update age of the record with ID = 102;
					      int rows = stmt.executeUpdate();
					      System.out.println("Rows impacted : " + rows );

					      // Let us select all the records and display them.
					      sql = "SELECT id, name ,address, location FROM employeefc";
					      ResultSet rs = stmt.executeQuery(sql);

					      //STEP 5: Extract data from result set
					      while(rs.next()){
					         //Retrieve by column name
					         int eid  = rs.getInt("id");
					         String name1 = rs.getString("name");
					         String address1 = rs.getString("address");
					         String location1 = rs.getString("location");

					         //Display values
					         System.out.print("ID: " + eid);
					         System.out.print(", Age: " + name1);
					         System.out.print(", First: " + address1);
					         System.out.println(", Last: " + location1);
					      }*/
					      //STEP 6: Clean-up environment
					     // rs.close();
					      stmt.close();
					      conn.close();
					   }catch(SQLException se){
					      //Handle errors for JDBC
					      se.printStackTrace();
					   }catch(Exception e){
					      //Handle errors for Class.forName
					      e.printStackTrace();
					   }finally{
					      //finally block used to close resources
					      try{
					         if(stmt!=null)
					            stmt.close();
					      }catch(SQLException se2){
					      }// nothing we can do
					      try{
					         if(conn!=null)
					            conn.close();
					      }catch(SQLException se){
					         se.printStackTrace();
					      }//end finally try
					   }//end try
					   System.out.println("Goodbye!");
	}

	@Override
	public void checkAvailabilityDAO(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewCourses(Student student) {
		// TODO Auto-generated method stub
		
	}

}
