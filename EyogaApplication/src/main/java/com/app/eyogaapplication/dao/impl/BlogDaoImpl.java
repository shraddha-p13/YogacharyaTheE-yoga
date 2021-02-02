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

import com.app.eyogaapplication.dao.BlogDao;
import com.app.eyogaapplication.model.BlogDetails;

@Repository
public class BlogDaoImpl implements BlogDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	//insert
	@Override
	public int insertBlogInformation(BlogDetails blogDetails) {

		String sql = "INSERT INTO blog_details(id,name,description)VALUES(?,?,?)";

		return jdbcTemplate.update(sql, blogDetails.getId(), blogDetails.getName(), blogDetails.getDescription());
	}

	//list
	@Override
	public Optional<BlogDetails> getBlogDetailsById(String id) {

		String sql = "SELECT id,name,description FROM blog_details WHERE id = ?";
		Object[] params = new Object[] { id };

		BlogDetails blogDetails = jdbcTemplate.query(sql, new ResultSetExtractor<BlogDetails>() {
			@Override
			public BlogDetails extractData(ResultSet rs) throws SQLException, DataAccessException {

				BlogDetails blogDetails = null;

				while (rs.next()) {

					blogDetails = new BlogDetails();
					blogDetails.setId(rs.getString("id"));
					blogDetails.setName(rs.getString("name"));
					blogDetails.setDescription(rs.getString("description"));
				}

				return blogDetails;
			}
		}, params);

		return Optional.ofNullable(blogDetails);
	}

	//update by Id
	@Override
	public int updateBlogDetailsById(BlogDetails blogDetails) {

		String query = "UPDATE blog_details SET name =?,description = ? WHERE id = ?";

		return jdbcTemplate.update(query, new Object[] { blogDetails.getName(), blogDetails.getDescription(), blogDetails.getId() });
	}

	//delete by Id
	@Override
	public int deleteBlogDetailsById(String id) {

		String sql = "DELETE FROM blog_details WHERE id = ?";

		Object[] params = new Object[] { id };

		return jdbcTemplate.update(sql, params);
	}

	//list all 
	@Override
	public Optional<List<BlogDetails>> getAllBlogList() {

		String sql = "SELECT * FROM blog_details";

		List<BlogDetails> blogDetailsList = jdbcTemplate.query(sql, new ResultSetExtractor<List<BlogDetails>>() {
			@Override
			public List<BlogDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<BlogDetails> list = new ArrayList<BlogDetails>();
				BlogDetails blogDetails = null;
				while (rs.next()) {
					blogDetails = new BlogDetails();
					blogDetails.setId(rs.getString("id"));
					blogDetails.setName(rs.getString("name"));
					blogDetails.setDescription(rs.getString("description"));
					list.add(blogDetails);
				}

				return list;
			}
		});
		if (blogDetailsList.isEmpty()) {
			return Optional.empty();
		}
		return Optional.ofNullable(blogDetailsList);
	}

}
