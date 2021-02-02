package com.app.eyogaapplication.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.eyogaapplication.dao.CourseDao;
import com.app.eyogaapplication.model.BlogDetails;
import com.app.eyogaapplication.model.CourseDetails;
import com.app.eyogaapplication.service.CourseService;
import com.app.eyogaapplication.utils.UUIDUtils;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	
	@Override
	public int updateCourseDetailsById(CourseDetails courseDetails) {
		int status = courseDao.updateCourseDetailsById(courseDetails);
		return status;
	}

	

	@Override
	public int insertCourseInformation(CourseDetails courseDetails) {
		int status = 0;

		String id = UUIDUtils.generateUUID();
		courseDetails.setId(id);
		status = courseDao.insertCourseInformation(courseDetails);

		return status;
	}



	@Override
	public Optional<CourseDetails> getCourseDetailsById(String id) {
		Optional<CourseDetails> courseDetails = courseDao.getCourseDetailsById(id);
		return courseDetails;
	}



	@Override
	public int deleteCourseDetails(String id) {
		int status = courseDao.deleteCourseDetailsById(id);
		return status;
	}



	@Override
	public Optional<List<CourseDetails>> getAllCourseList() {
		Optional<List<CourseDetails>> courseDetailsList = courseDao.getAllCourseList();
		return courseDetailsList;
	}

}
