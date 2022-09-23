package com.lti.service;

import com.lti.bean.SemesterRegistration;
import com.lti.bean.Student;
import com.lti.bean.User;
import com.lti.dao.AdminDAO;
import com.lti.dao.AdminDAOImpl;
import com.lti.dao.UserDAO;
import com.lti.dao.UserDAOImpl;
import com.lti.exception.IncorrectPasswordException;
import com.lti.exception.SemesterRegistrationNotApprovedException;
import com.lti.exception.UserNotFoundException;

/**
 * @author Sebastian 
 *
 */

public class UserService implements UserServiceOperation {
	
	private UserDAO userdao;
	private AdminDAO admindao;
	
	public UserService() {
		
		userdao = new UserDAOImpl();
		admindao = new AdminDAOImpl();
	}
		
	public User Login(String username, String password) throws UserNotFoundException, IncorrectPasswordException, SemesterRegistrationNotApprovedException
	{		
		User user = userdao.LoginDAO(username);
		if(user == null) {
			
			throw new UserNotFoundException();
		}
		
		SemesterRegistration registration = admindao.getSemesterRegistrationDAO(user.getId());
		
		if(!password.equals(user.getPassword())) {
			
			throw new IncorrectPasswordException();
		}
		else if(registration.isApprovalStatus()) {
			
			System.out.println("\n--You have logged in--");
		}
		else {
			throw new SemesterRegistrationNotApprovedException(user);
		}
		return user;
	}
	
	public void Logout(String username) {
		
		System.out.println("\nYou have logged out");
	}
}
