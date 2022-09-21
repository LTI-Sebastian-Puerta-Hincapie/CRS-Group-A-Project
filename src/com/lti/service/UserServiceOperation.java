/**
 * 
 */
package com.lti.service;

import com.lti.bean.User;

/**
 * @author Sebastian
 *
 */
public interface UserServiceOperation {
	
	/**
	 * This method validates the user login credentials 
	 * @param String username
	 * @param String password
	 * @return User 
	 */
	public User Login(String username, String password);
	
	/**
	 * This method validates the user logout
	 * @param String username
	 * @param String password
	 */
	public void Logout(String username, String password);
}
