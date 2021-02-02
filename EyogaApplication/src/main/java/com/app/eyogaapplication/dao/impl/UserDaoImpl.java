package com.app.eyogaapplication.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.app.eyogaapplication.dao.UserDao;
import com.app.eyogaapplication.model.CourseDetailsDto;
import com.app.eyogaapplication.model.InstructorCourseDto;
import com.app.eyogaapplication.model.InstructorDetails;
import com.app.eyogaapplication.model.UserDetails;
import com.app.eyogaapplication.utils.Constants;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Optional<List<UserDetails>> getUserListByRoleId(String roleId) {
		
		
		String sql = "SELECT UD.id, UD.first_name, UD.last_name, UD.email, UD.contact_number FROM user_details UD INNER JOIN user_role_details URD ON UD.id = URD.user_id WHERE URD.role_id= ? ";
		
		Object[] params = new Object[] {roleId};
		List<UserDetails> userDetailsList = jdbcTemplate.query(sql, new ResultSetExtractor<List<UserDetails>>() {
			@Override
			public List<UserDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<UserDetails> list = new ArrayList<UserDetails>();
				UserDetails userDetails = null;
				while (rs.next()) {
					userDetails = new UserDetails();
					userDetails.setId(rs.getString("id"));
					userDetails.setFirstName(rs.getString("first_name"));
					userDetails.setLastName(rs.getString("last_name"));
					userDetails.setEmail(rs.getString("email"));
					userDetails.setContactNumber(rs.getString("contact_number"));
					list.add(userDetails);
				}

				return list;
			}
		},params);
		if (userDetailsList.isEmpty()) {
			return Optional.empty();
		}
		return Optional.ofNullable(userDetailsList);
	}

	@Override
	public int deleteInstructorCourseDetails(String id) {
		
		String sql = "DELETE FROM course_instructor_details WHERE instructor_id = ?";

		Object[] params = new Object[] { id };

		return jdbcTemplate.update(sql, params);
	}

	@Override
	public int deleteUserRoleDetailsByUserId(String id) {
		
		String sql = "DELETE FROM user_role_details WHERE user_id = ?";

		Object[] params = new Object[] { id };

		return jdbcTemplate.update(sql, params);
	}

	@Override
	public int deleteUserDetailsByUserId(String id) {
		
		String sql = "DELETE FROM user_details WHERE id = ?";

		Object[] params = new Object[] { id };

		return jdbcTemplate.update(sql, params);
	}

	@Override
	public Optional<List<CourseDetailsDto>> getInstructorWiseCourseList(String userId) {
		String sql = "SELECT CD.id, CD.name, CID.link FROM course_details CD INNER JOIN course_instructor_details CID ON CD.id=CID.course_id WHERE instructor_id = ?";
		
		Object[] params = new Object[] {userId};
		List<CourseDetailsDto> courseDetailsList = jdbcTemplate.query(sql, new ResultSetExtractor<List<CourseDetailsDto>>() {
			@Override
			public List<CourseDetailsDto> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<CourseDetailsDto> list = new ArrayList<CourseDetailsDto>();
				CourseDetailsDto courseDetailsDto = null;
				while (rs.next()) {
					courseDetailsDto = new CourseDetailsDto();
					courseDetailsDto.setId(rs.getString("id"));
					courseDetailsDto.setCourseName(rs.getString("name"));
					courseDetailsDto.setLink(rs.getString("link"));
					list.add(courseDetailsDto);
				}

				return list;
			}
		},params);
		if (courseDetailsList.isEmpty()) {
			return Optional.empty();
		}
		return Optional.ofNullable(courseDetailsList);
	}

	@Override
	public int updateCourseLink(InstructorCourseDto instructorCourseDto) {
		
		String query = "UPDATE course_instructor_details SET link =? WHERE course_id = ? AND instructor_id= ?";

		return jdbcTemplate.update(query, new Object[] { instructorCourseDto.getCourseLink(), instructorCourseDto.getCourseId(), instructorCourseDto.getInstructorId() });
	}

	@Override
	public Optional<List<InstructorDetails>> getCourseWiseInstructorList(String courseId) {
		
		String sql = "SELECT UD.id,UD.first_name,UD.last_name,UD.email,UD.contact_number,CID.link FROM user_details UD INNER JOIN user_role_details URD ON UD.id = URD.user_id AND URD.role_id = ? INNER JOIN course_instructor_details CID ON UD.id=CID.instructor_id WHERE CID.course_id=?";
		
		Object[] params = new Object[] {Constants.INSTRUCTOR_ROLE_ID,courseId};
		List<InstructorDetails> instructorDetailsList = jdbcTemplate.query(sql, new ResultSetExtractor<List<InstructorDetails>>() {
			@Override
			public List<InstructorDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<InstructorDetails> list = new ArrayList<InstructorDetails>();
				InstructorDetails instructorDetails = null;
				while (rs.next()) {
					instructorDetails = new InstructorDetails();
					instructorDetails.setInstructorName(rs.getString("first_name")+" "+rs.getString("last_name"));
					instructorDetails.setContactNumber(rs.getString("contact_number"));
					instructorDetails.setEmailId(rs.getString("email"));
					instructorDetails.setCourseLink(rs.getString("link"));
					list.add(instructorDetails);
				}

				return list;
			}
		},params);
		if (instructorDetailsList.isEmpty()) {
			return Optional.empty();
		}
		return Optional.ofNullable(instructorDetailsList);
	}
	
	
}
