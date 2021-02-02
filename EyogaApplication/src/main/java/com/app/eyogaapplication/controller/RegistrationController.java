package com.app.eyogaapplication.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.eyogaapplication.model.InstructorDetailsDto;
import com.app.eyogaapplication.model.UserDetails;
import com.app.eyogaapplication.model.UserDetailsDto;
import com.app.eyogaapplication.service.RegistrationService;
import com.app.eyogaapplication.utils.BaseRestController;

@RestController
public class RegistrationController extends BaseRestController {

	@Autowired
	private RegistrationService registrationService;

	@RequestMapping(value = "/api/register/admin")
	public ResponseEntity<?> registerAdmin(@RequestBody UserDetails userDetails, HttpServletRequest request) {

		boolean isUserExist = registrationService.isEmailIdAlreadyExistForOtherUsers(userDetails.getEmail());

		if (isUserExist) {
			return constructFailureResponse("failure.emailidalreadyexist", HttpStatus.BAD_REQUEST, request.getLocale());
		}

		int status = registrationService.registerAdmin(userDetails);

		if (status > 0) {
			return constructSuccessResponse("success.registration", HttpStatus.OK, request.getLocale());
		}
		return constructFailureResponse("failure.registration", HttpStatus.BAD_REQUEST, request.getLocale());
	}

	@RequestMapping(value = "/api/register/instructor")
	public ResponseEntity<?> registerInstructor(@RequestBody InstructorDetailsDto instructorDetailsDto, HttpServletRequest request) {

		boolean isUserExist = registrationService.isEmailIdAlreadyExistForOtherUsers(instructorDetailsDto.getEmail());

		if (isUserExist) {
			return constructFailureResponse("failure.emailidalreadyexist", HttpStatus.BAD_REQUEST, request.getLocale());
		}

		int status = registrationService.registerInstructor(instructorDetailsDto);

		if (status > 0) {
			return constructSuccessResponse("success.registration", HttpStatus.OK, request.getLocale());
		}
		return constructFailureResponse("failure.registration", HttpStatus.BAD_REQUEST, request.getLocale());
	}

	@RequestMapping(value = "/api/register/trainee")
	public ResponseEntity<?> registerTrainee(@RequestBody UserDetails userDetails, HttpServletRequest request) {

		boolean isUserExist = registrationService.isEmailIdAlreadyExistForOtherUsers(userDetails.getEmail());

		if (isUserExist) {
			return constructFailureResponse("failure.emailidalreadyexist", HttpStatus.BAD_REQUEST, request.getLocale());
		}

		Optional<UserDetailsDto> userDetailsDtoOptional = registrationService.registerTrainee(userDetails);

		if (userDetailsDtoOptional.isPresent()) {
			return constructSuccessResponseForObject(HttpStatus.OK, request.getLocale(), userDetailsDtoOptional.get());
		}
		return constructFailureResponse("failure.registration", HttpStatus.BAD_REQUEST, request.getLocale());
	}
}
