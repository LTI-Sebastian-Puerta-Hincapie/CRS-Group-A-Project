package com.lti.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lti.bean.Course;
import com.lti.bean.CourseCatalog;
import com.lti.bean.Professor;
import com.lti.bean.Student;
import com.lti.bean.User;
import com.lti.service.UserService;

public class CRSMenuApplication {
	
	// db - connection string
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/crs-group-a";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";
	
	public static void main(String[] args) {
			
			// ============  add data - initialize the db  =======================
			Connection conn = null;
			PreparedStatement stmt = null;	
			   
		   try {		  
			   
			  Class.forName("com.mysql.jdbc.Driver");
			  System.out.println("Connecting to database...");
			  conn = DriverManager.getConnection(DB_URL,USER,PASS);
			  
			  		  // insert users
			  
			  String sql="insert into Users values(?,?,?,?)";
			  stmt = conn.prepareStatement(sql);
			 			  
			  User user1 = new User(1, "tparker", "oranges123", 3);
			  User user2 = new User(2, "amalik", "cheese123", 3);
			  User user3 = new User(3, "twatkins", "ocean123", 3);
			  User user4 = new User(4, "test", "test123", 1);
			  User user5 = new User(5, "rwu", "mountain123", 2);
			  User user6 = new User(6, "aortega", "landscape123", 2);
			  User user7 = new User(7, "nmorrison", "fountain123", 2);
			  
			  List<User> users = new ArrayList<User>();
			  users.add(user1);
			  users.add(user2);
			  users.add(user3);
			  users.add(user4);
			  users.add(user5);
			  users.add(user6);
			  users.add(user7);
			  
			  for(User user : users) {
				  
				  stmt.setInt(1, user.getId());
				  stmt.setString(2,user.getUsername()); 
				  stmt.setString(3, user.getPassword());
				  stmt.setInt(4,user.getRoleId());
				  stmt.executeUpdate();	
			  }
			  
			  // insert professors
			  sql="insert into professors values(?,?,?,?,?,?)";
			  stmt = conn.prepareStatement(sql);
			 		  
			  Professor rubin = new Professor(1, "Rubin Wu", 1, "rwur@test.com", "111-222-3333", "Rubin Ave, NY");
			  Professor axel = new Professor(2, "Axel Ortega", 2, "aortega@test.com", "111-222-3333", "Axel Ln, NJ");
			  Professor nelson = new Professor(3, "Nelson Morrison", 3, "nmorrison@test.com", "111-222-3333", "Nelson Rd, CT");
			  
			  List<Professor> professors = new ArrayList<Professor>();
			  professors.add(rubin);
			  professors.add(axel);
			  professors.add(nelson);
			  
			  for(Professor professor : professors) {
				  stmt.setInt(1,professor.getId()); 
				  stmt.setString(2,professor.getName());
				  stmt.setInt(3,professor.getDepartmentId());
				  stmt.setString(4,professor.getEmail());
				  stmt.setString(5,professor.getPhone());
				  stmt.setString(6,professor.getAddress());
				  stmt.executeUpdate();	
			  }
			  
			  // insert students
			  sql="insert into Students values(?,?,?,?,?,?)";
			  stmt = conn.prepareStatement(sql);
			 		  
			  Student thomas = new Student(1, "Thomas Parker", 1, "tparker@test.com", "111-222-3333", "Parker Ave, NY");
			  Student abigail = new Student(2, "Abigail Malik", 2, "amalik@test.com", "111-222-3333", "Abigail Ln, NJ");
			  Student tej = new Student(3, "Tej Watkins", 3, "twatkins@test.com", "111-222-3333", "Tej Rd, CT");
			  
			  List<Student> students = new ArrayList<Student>();
			  students.add(thomas);
			  students.add(abigail);
			  students.add(tej);
			  
			  for(Student student : students) {
				  stmt.setInt(1,student.getId()); 
				  stmt.setString(2,student.getName());
				  stmt.setInt(3,student.getMajorId());
				  stmt.setString(4, student.getEmail());
				  stmt.setString(5,student.getPhone());
				  stmt.setString(6, student.getAddress());
				  stmt.executeUpdate();	
			  }
			  
			  // courses
			  sql="insert into course values(?,?,?)";
			  stmt = conn.prepareStatement(sql);
			  List<Course> courses = new ArrayList<Course>();
			  
			  // Biology courses - "Prof.Rubin"
			  courses.add(new Course(1, "Biology 0", "Science"));
			  courses.add(new Course(2, "Biology 1", "Science"));
			  courses.add(new Course(3, "Biology 2", "Science"));
			  
		      // Psychology courses - "Prof.Axel"
			  courses.add(new Course(4, "Psychology 0", "Behavioral Science"));
			  courses.add(new Course(5, "Psychology 1", "Behavioral Scienc"));
			  courses.add(new Course(6, "Psychology 2", "Behavioral Scienc"));
			  
			  // Economics Courses - "Prof.Nelson"
			  courses.add(new Course(7, "Economics 0", "Business"));
			  courses.add(new Course(8, "Economics 1", "Business"));
			  courses.add(new Course(9, "Economics 2", "Business"));
				
			  for(Course course : courses) {
				  stmt.setInt(1,course.getCourseId()); 
				  stmt.setString(2,course.getCourseName());
				  stmt.setString(3,course.getDescription()); 
				  stmt.executeUpdate();	
			  }
			  
			  // insert course catalog
			  sql="insert into CourseCatalog values(?,?,?,?,?,?,?,?)";
			  stmt = conn.prepareStatement(sql);
			  List<CourseCatalog> cg = new ArrayList<CourseCatalog>();
			  
			  // Biology courses - "Prof.Rubin"
			  cg.add(new CourseCatalog(1, 1, 100, "-", 3, 100, 0, "Fall 2022"));
			  cg.add(new CourseCatalog(2, 1, 100, "Biology 0", 3, 80, 0, "Fall 2022"));
			  cg.add(new CourseCatalog(3, 1, 100, "Biology 1", 3, 80, 0,"Fall 2022"));
			  
		      // Psychology courses - "Prof.Axel"
		      cg.add(new CourseCatalog(4, 2, 200, "-", 3, 100, 0, "Fall 2022"));
			  cg.add(new CourseCatalog(5, 2, 200, "Psychology 0", 3, 75, 0, "Fall 2022"));
			  cg.add(new CourseCatalog(6, 2, 200, "Psychology 1", 3, 75, 0, "Fall 2022"));
			  
			  // Economics Courses - "Prof.Nelson"
			  cg.add(new CourseCatalog(7, 3, 300, "-", 3, 50, 0, "Fall 2022"));
			  cg.add(new CourseCatalog(8, 3, 300, "Economics 0", 3, 50, 0, "Fall 2022"));
		      cg.add(new CourseCatalog(9, 3, 300, "Economics 1", 3, 50, 0, "Fall 2022"));
				
			  for(CourseCatalog course : cg) {
				  stmt.setInt(1,course.getId()); 
				  stmt.setInt(2,course.getProfessorId());
				  stmt.setInt(3,course.getDepartmentId()); 
				  stmt.setString(4,course.getPrerequisites());
				  stmt.setInt(5,course.getCredits());
				  stmt.setInt(6,course.getCapacity());
				  stmt.setInt(7,course.getEnrolled());
				  stmt.setString(8,course.getSemester());
				  stmt.executeUpdate();	
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

		
		// ---------------------------------------

		String username = "";
		String password = "";
		UserService userService = new UserService();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("******************Welcome to the CRS Application*************");
		
		// Main menu selection loop
		while(true) {
			
			System.out.println("\nEnter selection: ");
			System.out.println("1. Login");
			System.out.println("2. Student Registration");
			System.out.println("3. Update Password");
			System.out.println("4. Exit");
			System.out.print("\n-> ");
			
			String selection = scan.nextLine();
			
			Boolean exit = false;
			
			switch(selection.toLowerCase()) {
				case "login":
					
					System.out.print("\nEnter Username: ");
					username = scan.next();
					
					System.out.print("Enter Password: ");
					password = scan.next();		
					
					// validate login
					Boolean isLoggedIn = userService.Login(username, password);
					if(isLoggedIn) {
						System.out.println("\nYou have logged in");
					}
					else {
						System.out.println("\nusername and password combination is incorrect or does not exist");
						break;
					}
					
					// menus
					CRSStudentMenu studentMenu = new CRSStudentMenu(scan, username);
					CRSProfessorMenu professorMenu = new CRSProfessorMenu(scan, username);
					CRSAdminMenu adminMenu = new CRSAdminMenu(scan, username);
					
					// TODO: login credential validation method here						
					
					// Role Selection Loop
					while(true) {
					
						System.out.println("\nEnter Role: ");
						System.out.println("1. Student");
						System.out.println("2. Professor");
						System.out.println("3. Admin");
						System.out.println("4. Back");
						System.out.print("\n-> ");
						String role = scan.next();
						
						Boolean role_back = false;
						switch(role.toLowerCase()) {
							case "student": 								
								System.out.println("\nWelcome Student " + "(" + username.toUpperCase() + ")");
								studentMenu.menu();
								break;			
							case "professor": 
								System.out.println("\nWelcome Professor " + "(" + username.toUpperCase() + ")");
								professorMenu.menu();
								break;		
							case "admin": 
								System.out.println("\nWelcome Admin" + "(" + username.toUpperCase() + ")");
								adminMenu.menu();
								break;					
							case "back":
								role_back = true;
								break;
							default:
								System.out.println("Please make another selection, role not found\n");
								continue;
						}
						if(role_back) break;  // exit out of role while loop
					}	
					break;  	// login switch case
				case "student registration": 
					System.out.println("Student Registration...");
					break;
				case "update password": 
					System.out.println("Updating Password...");
					break;
				case "exit": 
					exit = true;
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Please make another selection, option not found\n");
					continue;
			}
			
			if(exit) break;    // exit out of main menu loop
		}
		
		userService.Logout(username, password);
		System.out.println("\nEnd of program");	
	}
}
