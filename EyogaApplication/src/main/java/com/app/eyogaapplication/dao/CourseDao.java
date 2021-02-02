package com.app.eyogaapplication.dao;


import java.util.List;
import java.util.Optional;


import com.app.eyogaapplication.model.CourseDetails;

public interface CourseDao {

	int insertCourseInformation(CourseDetails courseDetails);
	
	Optional<CourseDetails> getCourseDetailsById(String id);
	
	int updateCourseDetailsById(CourseDetails courseDetails);
	
	int deleteCourseDetailsById(String id);

	Optional<List<CourseDetails>> getAllCourseList();


}
