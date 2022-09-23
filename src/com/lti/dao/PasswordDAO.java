package com.lti.dao;

/**
 * @author Rehmath  
 *
 */
public interface PasswordDAO {
	
	
	/**
	 * This method updates the user password
	 * @param String username
	 * @param String password
	 */
	public void updatePassword(String username, String password);
}
