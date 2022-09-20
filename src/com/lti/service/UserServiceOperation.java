/**
 * 
 */
package com.lti.service;

/**
 * @author Sebastian
 *
 */
public interface UserServiceOperation {
	
	public Boolean Login(String username, String password);
	
	public void Logout(String username, String password);
}
