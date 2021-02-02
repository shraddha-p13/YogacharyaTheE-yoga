package com.app.eyogaapplication.service;

import java.util.Optional;

import com.app.eyogaapplication.model.InstructorDetailsDto;
import com.app.eyogaapplication.model.LoginDetails;
import com.app.eyogaapplication.model.UserDetails;
import com.app.eyogaapplication.model.UserDetailsDto;

public interface RegistrationService {

	int registerAdmin(UserDetails userDetails);

	int registerInstructor(InstructorDetailsDto instructorDetailsDto);

	Optional<UserDetailsDto> registerTrainee(UserDetails userDetails);

	boolean isEmailIdAlreadyExistForOtherUsers(String email);

	Optional<UserDetailsDto> loginUser(LoginDetails loginDetails);

}
