package com.lti.bean;

public class Course {
	
	private int id;
	private String name;
	private int professorId;
	private int departmentId;
	private String prerequisites;
	private int credits;
	private int capacity;
	private int enrolled;
	private String semester;
	
	public Course(int id, String name, int professorId, int departmentId, 
			String prerequisites, int credits, int capacity, int enrolled, String semester) {
		
		this.id = id;
		this.name = name;
		this.professorId = professorId;
		this.departmentId = departmentId;
		this.prerequisites = prerequisites;
		this.credits = credits;
		this.capacity = capacity;
		this.enrolled = 0;
		this.semester = semester;
	}

	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return the enrolled
	 */
	public int getEnrolled() {
		return enrolled;
	}

	/**
	 * @param enrolled the enrolled to set
	 */
	public void setEnrolled(int enrolled) {
		this.enrolled = enrolled;
	}

	/**
	 * @return the semester
	 */
	public String getSemester() {
		return semester;
	}

	/**
	 * @param semester the semester to set
	 */
	public void setSemester(String semester) {
		this.semester = semester;
	}

	/**
	 * @param professorId the professorId to set
	 */
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	/**
	 * @return the credits
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * @param credits the credits to set
	 */
	public void setCredits(int credits) {
		this.credits = credits;
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
	 * @return the professor
	 */
	public int getProfessorId() {
		return professorId;
	}

	/**
	 * @param professor the professor to set
	 */
	public void setProfessor(int professorId) {
		this.professorId = professorId;
	}

	/**
	 * @return the department
	 */
	public int getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return the prerequisites
	 */
	public String getPrerequisites() {
		return prerequisites;
	}

	/**
	 * @param prerequisites the prerequisites to set
	 */
	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}	
}
