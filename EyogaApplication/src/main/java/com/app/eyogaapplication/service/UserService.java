package com.app.eyogaapplication.service;

import java.util.List;
import java.util.Optional;

import com.app.eyogaapplication.model.CourseDetailsDto;
import com.app.eyogaapplication.model.InstructorCourseDto;
import com.app.eyogaapplication.model.InstructorDetails;
import com.app.eyogaapplication.model.UserDetails;

public interface UserService {
	
	Optional<List<UserDetails>> getUserListByRoleId(String roleId);

	int deleteInstructorDetails(String id);

	Optional<List<CourseDetailsDto>> getInstructorWiseCourseList(String userId);

	int updateCourseLink(InstructorCourseDto instructorCourseDto);

	Optional<List<InstructorDetails>> getCourseWiseInstructorList(String courseId);

}
