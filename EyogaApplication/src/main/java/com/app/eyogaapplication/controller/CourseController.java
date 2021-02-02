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

import com.app.eyogaapplication.model.CourseDetails;
import com.app.eyogaapplication.service.CourseService;
import com.app.eyogaapplication.utils.BaseRestController;

@RestController
public class CourseController extends BaseRestController{

	@Autowired
	private CourseService courseService;
	
	//insert
	@RequestMapping(value = "/api/course", method = RequestMethod.POST)
	public ResponseEntity<?> insertCourseInformation(HttpServletRequest request, @RequestBody CourseDetails courseDetails) {

		int status = courseService.insertCourseInformation(courseDetails);

		if (status <= 0) {
			return constructFailureResponse("failure.addCourse", HttpStatus.BAD_REQUEST, request.getLocale());
		}

		return constructSuccessResponse("success.addCourse", HttpStatus.OK, request.getLocale());
	}
	
	//update by Id
	@RequestMapping(value = "/api/course/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCourseDetailsById(HttpServletRequest request, @RequestBody CourseDetails courseDetails, @PathVariable String id) {

		courseDetails.setId(id);

		int status = courseService.updateCourseDetailsById(courseDetails);

		if (status <= 0) {
			return constructFailureResponse("failure.courseUpdate", HttpStatus.BAD_REQUEST, request.getLocale());
		}
		return constructSuccessResponse("success.courseUpdate", HttpStatus.OK, request.getLocale());
	}
	
	//insert by id
		@RequestMapping(value = "/api/course/{id}", method = RequestMethod.GET)
		public ResponseEntity<?> getCourseDetailsById(HttpServletRequest request, @PathVariable String id) {

			Optional<CourseDetails> courseDetails = courseService.getCourseDetailsById(id);

			if (courseDetails.isPresent()) {

				return constructSuccessResponseForObject(HttpStatus.OK, request.getLocale(), courseDetails.get());
			} else {
				return constructFailureResponse("courseDetailsNotFound", HttpStatus.NOT_FOUND, request.getLocale());
			}

		}
		
		//delete
		@RequestMapping(value = "/api/course/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<?> deleteCourseDetails(HttpServletRequest request, @PathVariable String id) {

			if (id == null) {
				return constructFailureResponse("courseIdRequired", HttpStatus.NOT_FOUND, request.getLocale());
			}

			int deleted = courseService.deleteCourseDetails(id);

			if (deleted <= 0) {
				return constructFailureResponse("failure.deleteCourseDetails", HttpStatus.NOT_FOUND, request.getLocale());
			}

			return constructSuccessResponse("success.deleteCourseDetails", HttpStatus.OK, request.getLocale());
		}

		//list all
		@RequestMapping(value = "/api/course/list", method = RequestMethod.GET)
		public ResponseEntity<?> getAllCourseList(HttpServletRequest request) {

			Optional<List<CourseDetails>> courseDetailsList = courseService.getAllCourseList();

			if (courseDetailsList.isPresent()) {
				return constructSuccessResponseForObject(HttpStatus.OK, request.getLocale(), courseDetailsList.get());
			} else {
				return constructFailureResponse("failure.getCourseDetailsList", HttpStatus.NOT_FOUND, request.getLocale());
			}

		}


	
	
	
}
