package com.app.eyogaapplication.dao;

import java.util.List;
import java.util.Optional;

import com.app.eyogaapplication.model.CourseDetailsDto;
import com.app.eyogaapplication.model.InstructorCourseDto;
import com.app.eyogaapplication.model.InstructorDetails;
import com.app.eyogaapplication.model.UserDetails;

public interface UserDao {

	Optional<List<UserDetails>> getUserListByRoleId(String roleId);

	int deleteInstructorCourseDetails(String id);

	int deleteUserRoleDetailsByUserId(String id);

	int deleteUserDetailsByUserId(String id);

	Optional<List<CourseDetailsDto>> getInstructorWiseCourseList(String userId);

	int updateCourseLink(InstructorCourseDto instructorCourseDto);

	Optional<List<InstructorDetails>> getCourseWiseInstructorList(String courseId);

}
