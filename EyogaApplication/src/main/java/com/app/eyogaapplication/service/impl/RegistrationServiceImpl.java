package com.app.eyogaapplication.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.eyogaapplication.dao.RegistrationDao;
import com.app.eyogaapplication.model.CourseInstructorDetails;
import com.app.eyogaapplication.model.InstructorDetailsDto;
import com.app.eyogaapplication.model.LoginDetails;
import com.app.eyogaapplication.model.Roles;
import com.app.eyogaapplication.model.UserDetails;
import com.app.eyogaapplication.model.UserDetailsDto;
import com.app.eyogaapplication.model.UserRoleDetails;
import com.app.eyogaapplication.service.RegistrationService;
import com.app.eyogaapplication.utils.Constants;
import com.app.eyogaapplication.utils.UUIDUtils;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationDao registrationDao;

	@Override
	public int registerAdmin(UserDetails userDetails) {
		
		String id = UUIDUtils.generateUUID();
		userDetails.setId(id);
		int status = registrationDao.insertUserDetails(userDetails);
		
		if(status > 0) {
			UserRoleDetails userRoles= new UserRoleDetails();
			String userRoleId = UUIDUtils.generateUUID();
			userRoles.setId(userRoleId);
			userRoles.setUserId(id);
			userRoles.setRoleId(Constants.ADMIN_ROLE_ID);
			status = registrationDao.insertUserRoleDetails(userRoles);
		}
	
		return status;
	}

	@Override
	public int registerInstructor(InstructorDetailsDto instructorDetailsDto) {
		String id = UUIDUtils.generateUUID();
		UserDetails userDetails = new UserDetails();
		userDetails.setId(id);
		userDetails.setFirstName(instructorDetailsDto.getFirstName());
		userDetails.setLastName(instructorDetailsDto.getLastName());
		userDetails.setEmail(instructorDetailsDto.getEmail());
		userDetails.setPassword(instructorDetailsDto.getPassword());
		userDetails.setContactNumber(instructorDetailsDto.getContactNumber());
		
		int status = registrationDao.insertUserDetails(userDetails);
		
		if(status > 0) {
			UserRoleDetails userRoles= new UserRoleDetails();
			String userRoleId = UUIDUtils.generateUUID();
			userRoles.setId(userRoleId);
			userRoles.setUserId(id);
			userRoles.setRoleId(Constants.INSTRUCTOR_ROLE_ID);
			status = registrationDao.insertUserRoleDetails(userRoles);
			
			List<String> courseIdList = instructorDetailsDto.getCourseList();
			List<CourseInstructorDetails> courseInstructorDetailsList = new ArrayList<>();
			CourseInstructorDetails courseInstructorDetails = null;
			for (String courseId : courseIdList) {
				courseInstructorDetails = new CourseInstructorDetails();
				String tempId = UUIDUtils.generateUUID();
				courseInstructorDetails.setId(tempId);
				courseInstructorDetails.setCourseId(courseId);
				courseInstructorDetails.setInstructorId(id);
				courseInstructorDetailsList.add(courseInstructorDetails);
			}
			
			status=registrationDao.insertCourseInstructorDetails(courseInstructorDetailsList);
		}
	
		return status;
	}

	@Override
	public Optional<UserDetailsDto> registerTrainee(UserDetails userDetails) {
		UserDetailsDto userDetailsDto =null;
		String id = UUIDUtils.generateUUID();
		userDetails.setId(id);
		int status = registrationDao.insertUserDetails(userDetails);
		
		if(status > 0) {
			UserRoleDetails userRoles= new UserRoleDetails();
			String userRoleId = UUIDUtils.generateUUID();
			userRoles.setId(userRoleId);
			userRoles.setUserId(id);
			userRoles.setRoleId(Constants.TRAINEE_ROLE_ID);
			status = registrationDao.insertUserRoleDetails(userRoles);
		}
		
		if(status>0) {
			userDetailsDto = new UserDetailsDto();
			userDetailsDto.setFirstName(userDetails.getFirstName());
			userDetailsDto.setLastName(userDetails.getLastName());
			userDetailsDto.setEmail(userDetails.getEmail());
			userDetailsDto.setContactNumber(userDetails.getContactNumber());
			userDetailsDto.setId(id);
			
			List<Roles> userRoleList= new ArrayList<>();
			Roles roles = new Roles();
			roles.setId(Constants.TRAINEE_ROLE_ID);
			roles.setRoleName(Constants.TRAINEE_ROLE_NAME);
			userRoleList.add(roles);
			
			userDetailsDto.setUserRoleList(userRoleList);
		}
		return Optional.ofNullable(userDetailsDto);
	}

	@Override
	public boolean isEmailIdAlreadyExistForOtherUsers(String email) {
		
		boolean status = registrationDao.isEmailIdAlreadyExistForOtherUsers(email);
		
		return status;
	}

	@Override
	public Optional<UserDetailsDto> loginUser(LoginDetails loginDetails) {
		Optional<UserDetailsDto> userDetailsDto = registrationDao.getUserDetailsByEmailId(loginDetails.getEmail());
		boolean passwordStatus=false;
		if(userDetailsDto.isPresent()) {
			UserDetailsDto userDetailsDtoData= userDetailsDto.get();
			if(userDetailsDtoData.getPassword().equals(loginDetails.getPassword())) {
				passwordStatus = true;
				userDetailsDto.get().setPassword(null);
			}else {
				return Optional.empty();
			}
			
			if(passwordStatus) {
				Optional<List<Roles>> userRolesOptionalList=registrationDao.getUserRoleList(userDetailsDto.get().getId());
				if(userRolesOptionalList.isPresent()) {
					userDetailsDto.get().setUserRoleList(userRolesOptionalList.get());
				}
			}
		}
		return userDetailsDto;
	}
	
}
