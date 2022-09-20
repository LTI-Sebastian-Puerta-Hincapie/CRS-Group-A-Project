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
	
	public User LoginDAO(String username);
	
	public void LogoutDAO(String username);
}
