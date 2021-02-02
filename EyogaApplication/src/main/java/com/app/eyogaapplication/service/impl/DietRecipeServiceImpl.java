package com.app.eyogaapplication.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.eyogaapplication.dao.DietPlanDao;
import com.app.eyogaapplication.dao.DietRecipeDao;
import com.app.eyogaapplication.model.DietPlanDetails;
import com.app.eyogaapplication.model.DietRecipeDetails;
import com.app.eyogaapplication.service.DietRecipeService;
import com.app.eyogaapplication.utils.UUIDUtils;

public class DietRecipeServiceImpl implements DietRecipeService {

	@Autowired
	private DietRecipeDao dietRecipeDao;
	@Override
	public int insertDietRecipeInformation(DietRecipeDetails dietRecipeDetails) {
		
		int status = 0;
		
		String id = UUIDUtils.generateUUID();
		dietRecipeDetails.setId(id);
		status = dietRecipeDao.insertDietRecipeInformation(dietRecipeDetails);
		
		return status;
	}

	@Override
	public Optional<DietRecipeDetails> getDietRecipeDetailsById(String id) {
		
		Optional<DietRecipeDetails> dietRecipeDetails = dietRecipeDao.getDietRecipeDetailsById(id);
		return dietRecipeDetails;
	}

	@Override
	public int updateDietRecipeDetailsById(DietRecipeDetails dietRecipeDetails) {
		int status = dietRecipeDao.updateDietRecipeDetailsById(dietRecipeDetails);
		return status;
	}

	@Override
	public int deleteDietRecipeDetails(String id) {
		int status = dietRecipeDao.deleteDietRecipeDetails(id);
		return status;
	}

	@Override
	public Optional<List<DietRecipeDetails>> getAllDietRecipeList() {
		Optional<List<DietRecipeDetails>> dietRecipeDetailsList = dietRecipeDao.getAllDietRecipeList();
		return dietRecipeDetailsList;
	}

}
