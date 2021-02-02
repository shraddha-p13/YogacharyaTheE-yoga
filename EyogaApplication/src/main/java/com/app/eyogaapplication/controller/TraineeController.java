package com.app.eyogaapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.app.eyogaapplication.service.TraineeService;

@RestController
public class TraineeController {
	
	@Autowired
	private TraineeService traineeService;
	
/*	@Autowired
	private TraineeService traineeService;
	
	@PostMapping("/save-trainee")
	
	public ResponseData registerTrainee(@RequestBody TraineeData traineeData) 
	{
		System.out.println(traineeData.toString());
		traineeService.saveTrainee(traineeData);
		//return "Hello " + traineeData.getFname() + " " + traineeData.getLname() + "your registration is successful";
		ResponseData response=new ResponseData();
		response.setMessage("Record Inserted successfully");
		response.setMessageCode(HttpStatus.OK.toString());
		
		return response;
	}
	
	@GetMapping("/all-trainee")
	
	public Iterable<TraineeData> showAllTrainees()
	{
		return traineeService.showAllTrainees();
	}*/

}
