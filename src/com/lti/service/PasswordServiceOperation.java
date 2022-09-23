package com.lti.service;

import com.lti.bean.User;
import com.lti.exception.IncorrectPasswordException;
import com.lti.exception.UserNotFoundException;

/**
 * @author Rehmath
 *
 */
public interface PasswordServiceOperation {
	
	/**
	 * This method validates the user login credentials 
	 * @param username of type String
	 * @param password of type String
	 * @exception UserNotFoundException
	 * @exception IncorrectPasswordException
	 * @return User 
	 */
	public User validateUser(String username, String password) throws UserNotFoundException, IncorrectPasswordException;
	
	/**
	 * This method validates the user login credentials 
	 * @param username of type String
	 * @param password of type String
	 * @exception UserNotFoundException
	 * @exception IncorrectPasswordException
	 */
	public void updatePassword(String username, String password) ;
}
