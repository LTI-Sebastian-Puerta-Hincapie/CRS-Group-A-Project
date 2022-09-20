package com.lti.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO define and declare all the properties and respective getter/setter
public class Student {
	
	private int id;
	private String name;
	private int majorId;
	private String email;
	private String phone;
	private String address;
	private List<Course> courses;
	private Map<Course, Boolean> courseRegistration;
	
	public Student() {}
	
	public Student(int id, String name, int majorId, String email, String phone, String address) {
		
		this.id = id;
		this.name = name;
		this.majorId = majorId;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.courses = new ArrayList<Course>();
		this.courseRegistration = new HashMap<Course, Boolean>();
	}
	
	

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	public Map<Course, Boolean> getCourseRegistration() {
		return courseRegistration;
	}

	public void setCourseRegistration(Map<Course, Boolean> courseRegistration) {
		this.courseRegistration = courseRegistration;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	/**
	 * @return the major
	 */
	public int getMajorId() {
		return majorId;
	}

	/**
	 * @param major the major to set
	 */
	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the courses
	 */
	public List<Course> getCourses() {
		return courses;
	}

	/**
	 * @param courses the courses to set
	 */
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
	// --------- Added on student side (will need to update)  ---------
	public void addCourse(Course course) {
		
		this.courses.add(course);
	}
	
	public void dropCourse(Course course) {
		
		this.courseRegistration.remove(course);
		this.courses.remove(course);
	}
	
	public void registerCourse(Course course) {
		
		this.courseRegistration.put(course, true);
	}
}
