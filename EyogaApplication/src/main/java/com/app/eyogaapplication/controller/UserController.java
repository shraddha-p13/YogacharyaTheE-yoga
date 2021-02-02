package com.app.eyogaapplication.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.eyogaapplication.model.UserDetails;
import com.app.eyogaapplication.service.UserService;
import com.app.eyogaapplication.utils.BaseRestController;
import com.app.eyogaapplication.utils.Constants;

@RestController
public class UserController extends BaseRestController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/api/trainee/list", method = RequestMethod.GET)
	public ResponseEntity<?> getTraineeUserList(HttpServletRequest request) {

		Optional<List<UserDetails>> userDetailsList = userService.getUserListByRoleId(Constants.TRAINEE_ROLE_ID);

		if (userDetailsList.isPresent()) {
			return constructSuccessResponseForObject(HttpStatus.OK, request.getLocale(), userDetailsList.get());
		} else {
			return constructFailureResponse("failure.getTraineeList", HttpStatus.NOT_FOUND, request.getLocale());
		}

	}
	
	@RequestMapping(value = "/api/instructor/list", method = RequestMethod.GET)
	public ResponseEntity<?> getAllInstructorList(HttpServletRequest request) {

		Optional<List<UserDetails>> userDetailsList = userService.getUserListByRoleId(Constants.INSTRUCTOR_ROLE_ID);

		if (userDetailsList.isPresent()) {
			return constructSuccessResponseForObject(HttpStatus.OK, request.getLocale(), userDetailsList.get());
		} else {
			return constructFailureResponse("failure.getTraineeList", HttpStatus.NOT_FOUND, request.getLocale());
		}

	}
	
	@RequestMapping(value = "/api/instructor/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteInstructorDetails(HttpServletRequest request, @PathVariable String id) {

		if (id == null) {
			return constructFailureResponse("user.InstructorIdRequired", HttpStatus.NOT_FOUND, request.getLocale());
		}

		int deleted = userService.deleteInstructorDetails(id);

		if (deleted <= 0) {
			return constructFailureResponse("failure.deleteInstructorDetails", HttpStatus.NOT_FOUND, request.getLocale());
		}

		return constructSuccessResponse("success.deleteInstructorDetails", HttpStatus.OK, request.getLocale());
	}

}
