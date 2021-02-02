package com.app.eyogaapplication.service;

import java.util.List;
import java.util.Optional;

import com.app.eyogaapplication.model.DietPlanDetails;

public interface DietPlanService 
{

	int insertDietInformation(DietPlanDetails dietPlans);

	Optional<DietPlanDetails> getDietDetailsById(String id);

	int updateDietDetailsById(DietPlanDetails dietPlan);

	int deleteDietDetails(String id);

	Optional<List<DietPlanDetails>> getAllDietList();

}
