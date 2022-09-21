package com.lti.service;

import com.lti.bean.Student;
import com.lti.bean.User;
import com.lti.dao.UserDAO;
import com.lti.dao.UserDAOImpl;

/**
 * @author Sebastian 
 *
 */

public class UserService implements UserServiceOperation {
	
	private UserDAO userdao;
	
	public UserService() {
		
		userdao = new UserDAOImpl();
	}
		
	public User Login(String username, String password) {
		
		return userdao.LoginDAO(username);
	}
	
	public void Logout(String username, String password) {
		
		System.out.println("\nYou have logged out");
	}
}
