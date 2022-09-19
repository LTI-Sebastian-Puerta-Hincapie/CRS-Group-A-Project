package com.lti.service;

import com.lti.bean.User;

public class UserService implements UserServiceOperation {
	
	// default credentials
	private String thomasUsername;
	private String thomasPassword;
	private String abigailUsername;
	private String abigailPassword;
	private String tejUsername;
	private String tejPassword;
	
	public UserService() {
		
		thomasUsername = "thomas";
		thomasPassword = "welcome";
		abigailUsername = "abigail";
		abigailPassword = "apples";
		tejUsername = "tej";
		tejPassword = "mountains";
	}
	
	public void Login(String username, String password) {
		
		Boolean validate = false;
		switch(username) {
			case "thomas": 
				validate = password == thomasPassword ? true : false;
				System.out.println("\nYou have logged in");
				break;
			case "abigail": 
				validate = password == abigailPassword ? true : false;
				System.out.println("\nYou have logged in");
				break;
			case "tej": 
				validate = password == tejPassword ? true : false;
				System.out.println("\nYou have logged in");
				break;
			default: 
				System.out.println("\nNew user logged in");
				break;
		}
	}
	
	public void Logout(String username, String password) {
		
		System.out.println("\nYou have logged out");
	}
}
