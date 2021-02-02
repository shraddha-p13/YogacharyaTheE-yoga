package com.app.eyogaapplication.dao;

import java.util.List;
import java.util.Optional;

import com.app.eyogaapplication.model.CourseInstructorDetails;
import com.app.eyogaapplication.model.Roles;
import com.app.eyogaapplication.model.UserDetails;
import com.app.eyogaapplication.model.UserDetailsDto;
import com.app.eyogaapplication.model.UserRoleDetails;

public interface RegistrationDao {

	int insertUserDetails(UserDetails userDetails);

	int insertUserRoleDetails(UserRoleDetails userRoles);

	boolean isEmailIdAlreadyExistForOtherUsers(String email);

	Optional<UserDetailsDto> getUserDetailsByEmailId(String email);

	Optional<List<Roles>> getUserRoleList(String id);

	int insertCourseInstructorDetails(List<CourseInstructorDetails> courseInstructorDetailsList);

}
