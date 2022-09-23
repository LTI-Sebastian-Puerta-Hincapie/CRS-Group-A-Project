/**
 * 
 */
package com.lti.service;

import com.lti.bean.User;
import com.lti.exception.IncorrectPasswordException;
import com.lti.exception.SemesterRegistrationNotApprovedException;
import com.lti.exception.UserNotFoundException;

/**
 * @author Sebastian
 *
 */
public interface UserServiceOperation {
	
	/**
	 * This method validates the user login credentials 
	 * @param username of type integer
	 * @param password of type integer
	 * @exception UserNotFoundException
	 * @exception IncorrectPasswordException
	 * @exception SemesterRegistrationNotApprovedExceptionS
	 * @return User returns a user
	 */
	public User Login(String username, String password) throws UserNotFoundException, IncorrectPasswordException, SemesterRegistrationNotApprovedException;
	
	/**
	 * This method validates the user logout
	 * @param username of type String
	 */
	public void Logout(String username);
}
