package com.app.eyogaapplication.dao;

import java.util.List;
import java.util.Optional;

import com.app.eyogaapplication.model.DietPlanDetails;

public interface DietPlanDao 
{
	int insertDietInformation(DietPlanDetails dietPlans);

	Optional<DietPlanDetails> getDietDetailsById(String id);

	int updateDietDetailsById(DietPlanDetails dietPlans);

	int deleteDietDetailsById(String id);

	Optional<List<DietPlanDetails>> getAllDietList();

}
