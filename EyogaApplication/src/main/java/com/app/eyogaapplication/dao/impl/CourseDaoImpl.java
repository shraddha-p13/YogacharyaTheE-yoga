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

import com.app.eyogaapplication.dao.CourseDao;

import com.app.eyogaapplication.model.CourseDetails;

@Repository
public class CourseDaoImpl implements CourseDao {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	//insert
	@Override
	public int insertCourseInformation(CourseDetails courseDetails) {
		
		
		String sql = "INSERT INTO course_details(id,name,course_level)VALUES(?,?,?)";

		return jdbcTemplate.update(sql, courseDetails.getId(), courseDetails.getCourseName(), courseDetails.getCourseLevel());
	}
	
	//update by Id
	@Override
	public int updateCourseDetailsById(CourseDetails courseDetails) {
		String query = "UPDATE course_details SET name =?,course_level = ? WHERE id = ?";

		return jdbcTemplate.update(query, new Object[] { courseDetails.getCourseName(), courseDetails.getCourseLevel(), courseDetails.getId() });
	}
	
	//list
		@Override
		public Optional<CourseDetails> getCourseDetailsById(String id) {

			String sql = "SELECT id,name,course_level FROM course_details WHERE id = ?";
			Object[] params = new Object[] { id };

			CourseDetails courseDetails = jdbcTemplate.query(sql, new ResultSetExtractor<CourseDetails>() {
				@Override
				public CourseDetails extractData(ResultSet rs) throws SQLException, DataAccessException {

					CourseDetails courseDetails = null;

					while (rs.next()) {

						courseDetails = new CourseDetails();
						courseDetails.setId(rs.getString("id"));
						courseDetails.setCourseName(rs.getString("name"));
						courseDetails.setCourseLevel(rs.getString("course_level"));
					}

					return courseDetails;
				}
			}, params);

			return Optional.ofNullable(courseDetails);
		}

		//delete by Id
		@Override
		public int deleteCourseDetailsById(String id) {

			String sql = "DELETE FROM course_details WHERE id = ?";

			Object[] params = new Object[] { id };

			return jdbcTemplate.update(sql, params);
		}

		//list all 
		@Override
		public Optional<List<CourseDetails>> getAllCourseList() {

			String sql = "SELECT * FROM course_details";

			List<CourseDetails> courseDetailsList = jdbcTemplate.query(sql, new ResultSetExtractor<List<CourseDetails>>() {
				@Override
				public List<CourseDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {

					List<CourseDetails> list = new ArrayList<CourseDetails>();
					CourseDetails courseDetails = null;
					while (rs.next()) {
						courseDetails = new CourseDetails();
						courseDetails.setId(rs.getString("id"));
						courseDetails.setCourseName(rs.getString("name"));
						courseDetails.setCourseLevel(rs.getString("course_level"));
						list.add(courseDetails);
					}

					return list;
				}
			});
			if (courseDetailsList.isEmpty()) {
				return Optional.empty();
			}
			return Optional.ofNullable(courseDetailsList);
		}

	
	
}
