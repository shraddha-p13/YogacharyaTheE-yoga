package com.app.eyogaapplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import com.app.eyogaapplication.dao.InstructorDao;
import com.app.eyogaapplication.service.InstructorService;

@Service
public class InstructorServiceImpl implements InstructorService {

	
	@Autowired
	private InstructorDao instructorDao;
	
	
}
