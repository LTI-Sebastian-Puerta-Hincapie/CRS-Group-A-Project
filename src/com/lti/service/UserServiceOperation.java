/**
 * 
 */
package com.lti.service;

import com.lti.bean.User;
import com.lti.exception.IncorrectPasswordException;
import com.lti.exception.UserNotFoundException;

/**
 * @author Sebastian
 *
 */
public interface UserServiceOperation {
	
	/**
	 * This method validates the user login credentials 
	 * @param String username
	 * @param String password
	 * @exception UserNotFoundException
	 * @exception IncorrectPasswordException
	 * @return User 
	 */
	public User Login(String username, String password) throws UserNotFoundException, IncorrectPasswordException;
	
	/**
	 * This method validates the user logout
	 * @param String username
	 */
	public void Logout(String username);
}
