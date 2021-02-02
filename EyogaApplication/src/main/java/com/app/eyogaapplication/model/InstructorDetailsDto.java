package com.app.eyogaapplication.model;

import java.util.List;

public class InstructorDetailsDto extends UserDetails{

	private List<String> courseList;

	public List<String> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<String> courseList) {
		this.courseList = courseList;
	}
}
