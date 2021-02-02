package com.app.eyogaapplication.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.eyogaapplication.dao.BlogDao;
import com.app.eyogaapplication.model.BlogDetails;
import com.app.eyogaapplication.service.BlogService;
import com.app.eyogaapplication.utils.UUIDUtils;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDao blogDao;
	
	@Override
	public int insertBlogInformation(BlogDetails blogDetails) {
		int status = 0;
		
		String id = UUIDUtils.generateUUID();
		blogDetails.setId(id);
		status = blogDao.insertBlogInformation(blogDetails);
		
		return status;
	}

	@Override
	public Optional<BlogDetails> getBlogDetailsById(String id) {
		
		Optional<BlogDetails> blogDetails = blogDao.getBlogDetailsById(id);
		return blogDetails;
	}

	@Override
	public int updateBlogDetailsById(BlogDetails blogDetails) {
		
		int status = blogDao.updateBlogDetailsById(blogDetails);
		return status;
	}

	@Override
	public int deleteBlogDetails(String id) {
		
		int status = blogDao.deleteBlogDetailsById(id);
		return status;
	}

	@Override
	public Optional<List<BlogDetails>> getAllBlogList() {
		
		Optional<List<BlogDetails>> blogDetailsList = blogDao.getAllBlogList();
		return blogDetailsList;
	}

	
}
