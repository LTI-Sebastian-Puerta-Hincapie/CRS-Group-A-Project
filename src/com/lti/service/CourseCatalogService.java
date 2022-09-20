package com.lti.service;

import java.util.List;

import com.lti.bean.Course;
import com.lti.dao.CourseCatalogDAO;
import com.lti.dao.CourseCatalogDAOImpl;

/**
 * @author Sebastian
 *
 */

public class CourseCatalogService implements CourseCatalogOperation {
	
	private CourseCatalogDAO courseCatalogDao;
	
	public CourseCatalogService() {
		
		this.courseCatalogDao = new CourseCatalogDAOImpl();
	}

	@Override
	public List<Course> ListOfAllCourses() {
		
		return courseCatalogDao.ListOfAllCoursesDAO();
	}

}
