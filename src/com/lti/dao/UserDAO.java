/**
 * 
 */
package com.lti.dao;

/**
 * @author Sebastian 
 *
 */
public interface UserDAO {
	
	public String LoginDAO(String username);
	
	public void LogoutDAO(String username);
}
