/**
 * 
 */
package com.lti.service;

/**
 * @author user106
 *
 */
public interface UserServiceOperation {
	
	public void Login(String username, String password);
	
	public void Logout(String username, String password);
}
