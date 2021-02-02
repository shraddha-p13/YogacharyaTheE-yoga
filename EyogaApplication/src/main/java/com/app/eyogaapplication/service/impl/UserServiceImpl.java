package com.app.eyogaapplication.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.eyogaapplication.dao.UserDao;
import com.app.eyogaapplication.model.CourseDetailsDto;
import com.app.eyogaapplication.model.InstructorCourseDto;
import com.app.eyogaapplication.model.InstructorDetails;
import com.app.eyogaapplication.model.UserDetails;
import com.app.eyogaapplication.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public Optional<List<UserDetails>> getUserListByRoleId(String roleId) {
		
		Optional<List<UserDetails>> userDetailsList = userDao.getUserListByRoleId(roleId);
		return userDetailsList;
	}

	@Override
	public int deleteInstructorDetails(String id) {
		
		int status = userDao.deleteInstructorCourseDetails(id);
		status = userDao.deleteUserRoleDetailsByUserId(id);
		status=userDao.deleteUserDetailsByUserId(id);
		return status;
		
	}

	@Override
	public Optional<List<CourseDetailsDto>> getInstructorWiseCourseList(String userId) {
		
		Optional<List<CourseDetailsDto>> courseDetailsList=userDao.getInstructorWiseCourseList(userId);
		return courseDetailsList;
	}

	@Override
	public int updateCourseLink(InstructorCourseDto instructorCourseDto) {
		
		int status = userDao.updateCourseLink(instructorCourseDto);
		return status;
	}

	@Override
	public Optional<List<InstructorDetails>> getCourseWiseInstructorList(String courseId) {
		
		Optional<List<InstructorDetails>> instructorDetailsList=userDao.getCourseWiseInstructorList(courseId);
		return instructorDetailsList;
	}

	
}
