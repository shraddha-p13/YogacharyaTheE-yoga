package com.app.eyogaapplication.service;


import java.util.List;
import java.util.Optional;


import com.app.eyogaapplication.model.CourseDetails;

public interface CourseService {

	int insertCourseInformation(CourseDetails courseDetails);
	int updateCourseDetailsById(CourseDetails courseDetails);
	
	Optional<CourseDetails> getCourseDetailsById(String id);

	int deleteCourseDetails(String id);

	Optional<List<CourseDetails>> getAllCourseList();

}
