package com.app.eyogaapplication.service;

import java.util.List;
import java.util.Optional;


import com.app.eyogaapplication.model.DietRecipeDetails;

public interface DietRecipeService {
	int insertDietRecipeInformation(DietRecipeDetails dietRecipeDetails);

	Optional<DietRecipeDetails> getDietRecipeDetailsById(String id);

	int updateDietRecipeDetailsById(DietRecipeDetails dietRecipeDetails);

	int deleteDietRecipeDetails(String id);

	Optional<List<DietRecipeDetails>> getAllDietRecipeList();


}
