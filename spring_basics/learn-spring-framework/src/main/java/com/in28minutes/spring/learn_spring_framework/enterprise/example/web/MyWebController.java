package com.in28minutes.spring.learn_spring_framework.enterprise.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.spring.learn_spring_framework.enterprise.example.business.BusinessService;

@Component
public class MyWebController {
	
	//Field- Based Dependency Injection
	@Autowired // optional
	private BusinessService businessService;

	 // Constructor Based Dependency Injection
	 @Autowired 
	 public MyWebController(BusinessService businessService) {
	  System.out.println("Constructor -based Dependency Injection");
	  this.businessService = businessService; 
	 }
	 

	// Setter - Based Injection
	@Autowired
	public void setBusinessService(BusinessService businessService) {
		System.out.println("Setter -based Dependency Injection");
		this.businessService = businessService;
	}

	public long returnValueFromBusinessService() {
		return businessService.calculateSum();
	}

}
