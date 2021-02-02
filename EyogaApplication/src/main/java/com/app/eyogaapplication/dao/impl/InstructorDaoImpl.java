package com.app.eyogaapplication.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.eyogaapplication.dao.InstructorDao;

@Repository
public class InstructorDaoImpl implements InstructorDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
}
