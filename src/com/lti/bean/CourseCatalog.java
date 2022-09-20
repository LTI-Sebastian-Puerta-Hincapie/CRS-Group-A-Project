package com.lti.bean;

import java.util.ArrayList;

public class CourseCatalog {
	
	private ArrayList<Course> courses;
	
	// source of truth here
	
	public CourseCatalog() {
		
		courses = new ArrayList<Course>();
		
		// default data - initial in-memory data
		// Biology courses
//		courses.add(new Course(0, "Biology 0", "Rubin", "Biology", "-", 3));
//		courses.add(new Course(1, "Biology 1", "Rubin", "Biology", "Biology 0", 3));
//		courses.add(new Course(2, "Biology 2", "Rubin", "Biology", "Biology 1", 3));
//		// Psychology courses
//		courses.add(new Course(3, "Psychology 0", "Axel", "Psychology", "-", 3));
//		courses.add(new Course(4, "Psychology 1", "Axel", "Psychology", "Psychology 0", 3));
//		courses.add(new Course(5, "Psychology 2", "Axel", "Psychology", "Psychology 1", 3));
//		// Economics Courses
//		courses.add(new Course(6, "Economics 0", "Nelson", "Economics", "-", 3));
//		courses.add(new Course(7, "Economics 1", "Nelson", "Economics", "Economics 0", 3));
//		courses.add(new Course(8, "Economics 2", "Nelson", "Economics", "Economics 1", 3));
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
}
