package com.app.eyogaapplication.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.eyogaapplication.model.BlogDetails;
import com.app.eyogaapplication.service.BlogService;
import com.app.eyogaapplication.utils.BaseRestController;

@RestController
public class BlogController extends BaseRestController {

	@Autowired
	private BlogService blogService;

	//insert 
	@RequestMapping(value = "/api/blog", method = RequestMethod.POST)
	public ResponseEntity<?> insertBlogInformation(HttpServletRequest request, @RequestBody BlogDetails blogDetails) {

		int status = blogService.insertBlogInformation(blogDetails);

		if (status <= 0) {
			return constructFailureResponse("failure.addblog", HttpStatus.NOT_FOUND, request.getLocale());
		}

		return constructSuccessResponse("success.addblog", HttpStatus.OK, request.getLocale());
	}
	
	//insert by id
	@RequestMapping(value = "/api/blog/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getBlogDetailsById(HttpServletRequest request, @PathVariable String id) {

		Optional<BlogDetails> blogDetails = blogService.getBlogDetailsById(id);

		if (blogDetails.isPresent()) {

			return constructSuccessResponseForObject(HttpStatus.OK, request.getLocale(), blogDetails.get());
		} else {
			return constructFailureResponse("blog.detailsNotFound", HttpStatus.NOT_FOUND, request.getLocale());
		}

	}

	//update
	@RequestMapping(value = "/api/blog/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateBlogDetailsById(HttpServletRequest request, @RequestBody BlogDetails blogDetails, @PathVariable String id) {

		blogDetails.setId(id);

		int status = blogService.updateBlogDetailsById(blogDetails);

		if (status <= 0) {
			return constructFailureResponse("failure.blogUpdate", HttpStatus.BAD_REQUEST, request.getLocale());
		}
		return constructSuccessResponse("success.blogUpdate", HttpStatus.OK, request.getLocale());
	}

	//delete
	@RequestMapping(value = "/api/blog/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteBlogDetails(HttpServletRequest request, @PathVariable String id) {

		if (id == null) {
			return constructFailureResponse("blog.blogIdRequired", HttpStatus.NOT_FOUND, request.getLocale());
		}

		int deleted = blogService.deleteBlogDetails(id);

		if (deleted <= 0) {
			return constructFailureResponse("failure.deleteBlogDetails", HttpStatus.NOT_FOUND, request.getLocale());
		}

		return constructSuccessResponse("success.deleteBlogDetails", HttpStatus.OK, request.getLocale());
	}

	@RequestMapping(value = "/api/blog/list", method = RequestMethod.GET)
	public ResponseEntity<?> getAllBlogList(HttpServletRequest request) {

		Optional<List<BlogDetails>> blogDetailsList = blogService.getAllBlogList();

		if (blogDetailsList.isPresent()) {
			return constructSuccessResponseForObject(HttpStatus.OK, request.getLocale(), blogDetailsList.get());
		} else {
			return constructFailureResponse("failure.getBlogDetailsList", HttpStatus.NOT_FOUND, request.getLocale());
		}

	}

}
