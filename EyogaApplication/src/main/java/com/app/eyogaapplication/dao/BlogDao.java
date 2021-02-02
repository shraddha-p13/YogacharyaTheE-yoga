package com.app.eyogaapplication.dao;

import java.util.List;
import java.util.Optional;

import com.app.eyogaapplication.model.BlogDetails;

public interface BlogDao {

	int insertBlogInformation(BlogDetails blogDetails);

	Optional<BlogDetails> getBlogDetailsById(String id);

	int updateBlogDetailsById(BlogDetails blogDetails);

	int deleteBlogDetailsById(String id);

	Optional<List<BlogDetails>> getAllBlogList();

}
