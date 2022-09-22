package com.lti.service;

import com.lti.bean.Student;
import com.lti.bean.User;
import com.lti.dao.UserDAO;
import com.lti.dao.UserDAOImpl;
import com.lti.exception.IncorrectPasswordException;
import com.lti.exception.UserNotFoundException;

/**
 * @author Sebastian 
 *
 */

public class UserService implements UserServiceOperation {
	
	private UserDAO userdao;
	
	public UserService() {
		
		userdao = new UserDAOImpl();
	}
		
	public User Login(String username, String password) throws UserNotFoundException, IncorrectPasswordException
	{		
		User user = userdao.LoginDAO(username);
		if(user == null) {
			
			throw new UserNotFoundException();
		}
		else if(!password.equals(user.getPassword())) {
			
			throw new IncorrectPasswordException();
		}
		return user;
	}
	
	public void Logout(String username) {
		
		System.out.println("\nYou have logged out");
	}
}
