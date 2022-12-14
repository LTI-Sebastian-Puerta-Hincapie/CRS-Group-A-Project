package com.lti.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO define and declare all the properties and respective getter/setter
public class Student {
	
	private int id;
	private String name;
	private String major;
	private List<Course> courses;
	private Map<Course, Boolean> courseRegistration;
	
	public Student() {}
	
	public Student(int id, String name, String major) {
		
		this.id = id;
		this.name = name;
		this.major = major;
		this.courses = new ArrayList<Course>();
		this.courseRegistration = new HashMap<Course, Boolean>();
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
	public String getMajor() {
		return major;
	}

	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
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
