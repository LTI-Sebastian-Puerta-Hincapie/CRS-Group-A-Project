package com.lti.service;

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
		
	public Boolean Login(String username, String password) {
		
		Boolean isUserFound = false;
		String result = userdao.LoginDAO(username);
		
		isUserFound = password.equals(result) ? true : false;

		return isUserFound;
	}
	
	public void Logout(String username, String password) {
		
		System.out.println("\nYou have logged out");
	}
}
