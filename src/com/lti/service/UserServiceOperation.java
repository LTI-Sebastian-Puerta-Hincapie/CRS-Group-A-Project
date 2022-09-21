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
	
	public User Login(String username, String password);
	
	public void Logout(String username, String password);
}
