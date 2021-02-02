package com.app.eyogaapplication.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.eyogaapplication.model.CourseDetailsDto;
import com.app.eyogaapplication.model.InstructorCourseDto;
import com.app.eyogaapplication.model.InstructorDetails;
import com.app.eyogaapplication.service.UserService;
import com.app.eyogaapplication.utils.BaseRestController;

@RestController
public class InstructorController extends BaseRestController{

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/api/instructor/course/list/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getInstructorWiseCourseList(HttpServletRequest request,@PathVariable("id") String userId) {

		Optional<List<CourseDetailsDto>> courseDetailsList = userService.getInstructorWiseCourseList(userId);

		if (courseDetailsList.isPresent()) {
			return constructSuccessResponseForObject(HttpStatus.OK, request.getLocale(), courseDetailsList.get());
		} else {
			return constructFailureResponse("failure.getTraineeList", HttpStatus.NOT_FOUND, request.getLocale());
		}

	}
	
	@RequestMapping(value = "/api/instructor/course", method = RequestMethod.POST)
	public ResponseEntity<?> updateCourseLink(HttpServletRequest request, @RequestBody InstructorCourseDto instructorCourseDto) {

		int status = userService.updateCourseLink(instructorCourseDto);

		if (status <= 0) {
			return constructFailureResponse("failure.linkUpdate", HttpStatus.BAD_REQUEST, request.getLocale());
		}
		return constructSuccessResponse("success.linkUpdate", HttpStatus.OK, request.getLocale());
	}
	
	@RequestMapping(value = "/api/course/instructor/list/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCourseWiseInstructorList(HttpServletRequest request,@PathVariable("id") String courseId) {

		Optional<List<InstructorDetails>> instructorDetailsList = userService.getCourseWiseInstructorList(courseId);

		if (instructorDetailsList.isPresent()) {
			return constructSuccessResponseForObject(HttpStatus.OK, request.getLocale(), instructorDetailsList.get());
		} else {
			return constructFailureResponse("failure.getTraineeList", HttpStatus.NOT_FOUND, request.getLocale());
		}

	}
}
