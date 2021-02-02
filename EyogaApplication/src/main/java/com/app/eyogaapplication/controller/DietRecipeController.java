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

import com.app.eyogaapplication.model.DietRecipeDetails;
import com.app.eyogaapplication.service.DietRecipeService;
import com.app.eyogaapplication.utils.BaseRestController;

public class DietRecipeController extends BaseRestController {
	
	@Autowired
	private DietRecipeService dietRecipeService;
	
	@RequestMapping(value = "/api/dietrecipe", method = RequestMethod.POST)
	public ResponseEntity<?> insertDietRecipeInformation(HttpServletRequest request, @RequestBody DietRecipeDetails dietRecipe) {

		int status = dietRecipeService.insertDietRecipeInformation(dietRecipe);

		if (status <= 0) {
			return constructFailureResponse("failure.addDietRecipe", HttpStatus.NOT_FOUND, request.getLocale());
		}

		return constructSuccessResponse("success.addDietRecipe", HttpStatus.OK, request.getLocale());
	}

	

	@RequestMapping(value = "/api/dietrecipe/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getDietRecipeDetailsById(HttpServletRequest request, @PathVariable String id) {

		Optional<DietRecipeDetails> dietRecipe = dietRecipeService.getDietRecipeDetailsById(id);

		if (dietRecipe.isPresent()) {

			return constructSuccessResponseForObject(HttpStatus.OK, request.getLocale(), dietRecipe.get());
		} else {
			return constructFailureResponse("dietRecipe.detailsNotFound", HttpStatus.NOT_FOUND, request.getLocale());
		}

	}

	@RequestMapping(value = "/api/dietrecipe/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateDietRecipeDetailsById(HttpServletRequest request, @RequestBody DietRecipeDetails dietRecipe, @PathVariable String id) {

		dietRecipe.setId(id);

		int status = dietRecipeService.updateDietRecipeDetailsById(dietRecipe);

		if (status <= 0) {
			return constructFailureResponse("failure.dietRecipeUpdate", HttpStatus.BAD_REQUEST, request.getLocale());
		}
		return constructSuccessResponse("success.dietRecipeUpdate", HttpStatus.OK, request.getLocale());
	}

	@RequestMapping(value = "/api/dietrecipe/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteDietRecipeDetails(HttpServletRequest request, @PathVariable String id) {

		if (id == null) {
			return constructFailureResponse("dietRecipe.dietIdRequired", HttpStatus.NOT_FOUND, request.getLocale());
		}

		int deleted = dietRecipeService.deleteDietRecipeDetails(id);

		if (deleted <= 0) {
			return constructFailureResponse("failure.deleteDietRecipeDetails", HttpStatus.NOT_FOUND, request.getLocale());
		}

		return constructSuccessResponse("success.deleteDietRecipeDetails", HttpStatus.OK, request.getLocale());
	}

	@RequestMapping(value = "/api/dietrecipe/list", method = RequestMethod.GET)
	public ResponseEntity<?> getAllDietRecipeList(HttpServletRequest request) {

		Optional<List<DietRecipeDetails>> dietRecipeList = dietRecipeService.getAllDietRecipeList();

		if (dietRecipeList.isPresent()) {
			return constructSuccessResponseForObject(HttpStatus.OK, request.getLocale(),dietRecipeList.get());
		} else {
			return constructFailureResponse("failure.getDietRecipeList", HttpStatus.NOT_FOUND, request.getLocale());
		}

	}

	
	


}
