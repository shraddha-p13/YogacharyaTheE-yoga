package com.app.eyogaapplication.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.eyogaapplication.dao.RegistrationDao;
import com.app.eyogaapplication.model.CourseDetails;
import com.app.eyogaapplication.model.CourseInstructorDetails;
import com.app.eyogaapplication.model.Roles;
import com.app.eyogaapplication.model.UserDetails;
import com.app.eyogaapplication.model.UserDetailsDto;
import com.app.eyogaapplication.model.UserRoleDetails;


import org.springframework.jdbc.core.ResultSetExtractor;

@Repository
public class RegistrationDaoImpl implements RegistrationDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insertUserDetails(UserDetails userDetails) {
		
		String sql="INSERT INTO user_details(id, first_name, last_name, email, password, contact_number)VALUES(?,?,?,?,?,?)";
		return jdbcTemplate.update(sql,userDetails.getId(),userDetails.getFirstName(),userDetails.getLastName(),userDetails.getEmail(),userDetails.getPassword(),userDetails.getContactNumber());
	}

	@Override
	public int insertUserRoleDetails(UserRoleDetails userRoles) {
		String sql="INSERT INTO user_role_details(id, user_id, role_id)VALUES(?,?,?)";
		return jdbcTemplate.update(sql,userRoles.getId(),userRoles.getUserId(),userRoles.getRoleId());
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean isEmailIdAlreadyExistForOtherUsers(String email) {
		
		String sql = "SELECT (COUNT(*) > 0)  FROM user_details where email = ? ";
		
		Object[] params = new Object[] {email};
		
		boolean status = jdbcTemplate.queryForObject(sql, params, Boolean.class);
		
		return status;

	}

	@Override
	public Optional<UserDetailsDto> getUserDetailsByEmailId(String email) {
		
		
		String sql = "SELECT * FROM user_details WHERE email = ? ";
		
		Object[] params = new Object[] {email};
		
		UserDetailsDto user = jdbcTemplate.query(sql, new ResultSetExtractor<UserDetailsDto>() {
			public UserDetailsDto extractData(ResultSet rs) throws SQLException, DataAccessException {

				UserDetailsDto userDetailsDto =  null;
				while (rs.next()) {
					userDetailsDto = new UserDetailsDto();
				
					userDetailsDto.setId(rs.getString("id"));
					userDetailsDto.setFirstName(rs.getString("first_name"));
					userDetailsDto.setLastName(rs.getString("last_name"));
					userDetailsDto.setEmail(rs.getString("email"));
					userDetailsDto.setPassword(rs.getString("password"));
					userDetailsDto.setContactNumber(rs.getString("contact_number"));
				}

				return userDetailsDto;
			}
		}, params);
		
		return Optional.ofNullable(user);
	}

	@Override
	public Optional<List<Roles>> getUserRoleList(String id) {
		
		String sql  = "SELECT * FROM role R INNER JOIN user_role_details URD ON R.id = URD.role_id WHERE URD.user_id=?";
		
		Object[] params = new Object[] {id};
		
		List<Roles> roleList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Roles>>() {
			@Override
			public List<Roles> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<Roles> list = new ArrayList<Roles>();
				Roles role = null;
				while (rs.next()) {
					role= new Roles();
					role.setId(rs.getString("id"));
					role.setRoleName(rs.getString("role_name"));
					list.add(role);
				}

				return list;
			}
		},params);
		
		if (roleList.isEmpty()) {
			return Optional.empty();
		}
		
		return Optional.ofNullable(roleList);
	}

	@Override
	public int insertCourseInstructorDetails(List<CourseInstructorDetails> courseInstructorDetailsList) {
		
		
		String sql = "INSERT INTO course_instructor_details(id, course_id, instructor_id)VALUES( ?, ?, ?)";
		
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
	
				CourseInstructorDetails courseInstructorDetails = courseInstructorDetailsList.get(i);
	
				ps.setString(1, courseInstructorDetails.getId());
				ps.setString(2, courseInstructorDetails.getCourseId());
				ps.setString(3, courseInstructorDetails.getInstructorId());
			}
	
			@Override
			public int getBatchSize() {
				return courseInstructorDetailsList.size();
			}
		});
	
		return courseInstructorDetailsList.size();
	}
	
	
}
