package com.app.eyogaapplication.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.eyogaapplication.dao.DietPlanDao;
import com.app.eyogaapplication.model.DietPlanDetails;
import com.app.eyogaapplication.service.DietPlanService;

import com.app.eyogaapplication.utils.UUIDUtils;

@Service
public class DietPlanServiceImpl implements DietPlanService {
	
	@Autowired
	private DietPlanDao dietDao;

	@Override
	public int insertDietInformation(DietPlanDetails dietPlans) 
	{
		int status = 0;
		
		String id = UUIDUtils.generateUUID();
		dietPlans.setId(id);
		status = dietDao.insertDietInformation(dietPlans);
		
		return status;
		
	}

	@Override
	public Optional<DietPlanDetails> getDietDetailsById(String id) 
	{
		
		Optional<DietPlanDetails> dietPlan = dietDao.getDietDetailsById(id);
		return dietPlan;
	}

	@Override
	public int updateDietDetailsById(DietPlanDetails dietPlan) 
	{
		int status = dietDao.updateDietDetailsById(dietPlan);
		return status;
	}

	@Override
	public int deleteDietDetails(String id) 
	{
		int status = dietDao.deleteDietDetailsById(id);
		return status;
	}

	@Override
	public Optional<List<DietPlanDetails>> getAllDietList() 
	{
		Optional<List<DietPlanDetails>> dietPlanList = dietDao.getAllDietList();
		return dietPlanList;
	}

}
