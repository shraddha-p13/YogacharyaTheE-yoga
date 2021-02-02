package com.app.eyogaapplication.service;

import java.util.List;
import java.util.Optional;

import com.app.eyogaapplication.model.BlogDetails;

public interface BlogService {

	int insertBlogInformation(BlogDetails blogDetails);

	Optional<BlogDetails> getBlogDetailsById(String id);

	int updateBlogDetailsById(BlogDetails blogDetails);

	int deleteBlogDetails(String id);

	Optional<List<BlogDetails>> getAllBlogList();

}
