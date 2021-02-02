package com.app.eyogaapplication.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.eyogaapplication.model.LoginDetails;
import com.app.eyogaapplication.model.UserDetailsDto;
import com.app.eyogaapplication.service.RegistrationService;
import com.app.eyogaapplication.utils.BaseRestController;

@RestController
public class LoginController extends BaseRestController{

	@Autowired
	private RegistrationService registrationService;
	
	@RequestMapping(value="/api/login",method = RequestMethod.POST)
	public ResponseEntity<?> loginUser(@RequestBody LoginDetails loginDetails,HttpServletRequest request){

		Optional<UserDetailsDto> userDetailsDto = registrationService.loginUser(loginDetails);
		
		if (userDetailsDto.isPresent()) {
			return constructSuccessResponseForObject(HttpStatus.OK, request.getLocale(), userDetailsDto.get());
		}
		return constructFailureResponse("failure.invalidCredentials", HttpStatus.NOT_FOUND, request.getLocale());
	}
}
