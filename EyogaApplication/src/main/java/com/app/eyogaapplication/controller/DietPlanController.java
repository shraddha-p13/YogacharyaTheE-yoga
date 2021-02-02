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

import com.app.eyogaapplication.model.DietPlanDetails;
import com.app.eyogaapplication.service.DietPlanService;
import com.app.eyogaapplication.utils.BaseRestController;

@RestController
public class DietPlanController extends BaseRestController 
{
	
	@Autowired
	private DietPlanService dietService;
	
	@RequestMapping(value = "/api/dietplan", method = RequestMethod.POST)
	public ResponseEntity<?> insertDietInformation(HttpServletRequest request, @RequestBody DietPlanDetails dietPlan) {

		int status = dietService.insertDietInformation(dietPlan);

		if (status <= 0) {
			return constructFailureResponse("failure.addDietplan", HttpStatus.NOT_FOUND, request.getLocale());
		}

		return constructSuccessResponse("success.addDietplan", HttpStatus.OK, request.getLocale());
	}

	@RequestMapping(value = "/api/dietplan/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getDietDetailsById(HttpServletRequest request, @PathVariable String id) {

		Optional<DietPlanDetails> dietPlan = dietService.getDietDetailsById(id);

		if (dietPlan.isPresent()) {

			return constructSuccessResponseForObject(HttpStatus.OK, request.getLocale(), dietPlan.get());
		} else {
			return constructFailureResponse("dietPlans.detailsNotFound", HttpStatus.NOT_FOUND, request.getLocale());
		}

	}

	@RequestMapping(value = "/api/dietplans/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateDietDetailsById(HttpServletRequest request, @RequestBody DietPlanDetails dietPlan, @PathVariable String id) {

		dietPlan.setId(id);

		int status = dietService.updateDietDetailsById(dietPlan);

		if (status <= 0) {
			return constructFailureResponse("failure.dietUpdate", HttpStatus.BAD_REQUEST, request.getLocale());
		}
		return constructSuccessResponse("success.dietUpdate", HttpStatus.OK, request.getLocale());
	}

	@RequestMapping(value = "/api/dietplan/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteDietDetails(HttpServletRequest request, @PathVariable String id) {

		if (id == null) {
			return constructFailureResponse("dietPlans.dietIdRequired", HttpStatus.NOT_FOUND, request.getLocale());
		}

		int deleted = dietService.deleteDietDetails(id);

		if (deleted <= 0) {
			return constructFailureResponse("failure.deleteDietDetails", HttpStatus.NOT_FOUND, request.getLocale());
		}

		return constructSuccessResponse("success.deleteDietDetails", HttpStatus.OK, request.getLocale());
	}

	@RequestMapping(value = "/api/dietplan/list", method = RequestMethod.GET)
	public ResponseEntity<?> getAllDietList(HttpServletRequest request) {

		Optional<List<DietPlanDetails>> dietPlanList = dietService.getAllDietList();

		if (dietPlanList.isPresent()) {
			return constructSuccessResponseForObject(HttpStatus.OK, request.getLocale(),dietPlanList.get());
		} else {
			return constructFailureResponse("failure.getDietPlanList", HttpStatus.NOT_FOUND, request.getLocale());
		}

	}

	
	
}
