/**
 * 
 */
package com.lti.dao;

import com.lti.bean.User;

/**
 * @author Sebastian 
 *
 */
public interface UserDAO {
	
	/**
	 * This method validates the user login credentials 
	 * @param String username
	 * @param String password
	 * @return User 
	 */
	public User LoginDAO(String username);
	
	/**
	 * This method validates the user logout
	 * @param String username
	 */
	public void LogoutDAO(String username);
}
