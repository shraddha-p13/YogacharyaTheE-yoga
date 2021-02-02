package com.app.eyogaapplication.dao;

import java.util.List;
import java.util.Optional;

import com.app.eyogaapplication.model.DietRecipeDetails;

public interface DietRecipeDao {

	int insertDietRecipeInformation(DietRecipeDetails dietRecipeDetails);

	Optional<DietRecipeDetails> getDietRecipeDetailsById(String id);

	int updateDietRecipeDetailsById(DietRecipeDetails dietRecipeDetails);

	int deleteDietRecipeDetails(String id);

	Optional<List<DietRecipeDetails>> getAllDietRecipeList();

}
