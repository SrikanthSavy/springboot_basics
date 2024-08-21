package com.shoda.springboot.learn_spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrenctServiceController {
	
	@Autowired
	private CurrencyServiceConfiguration configuration;
	
	@RequestMapping("/currency-configuration")
	public CurrencyServiceConfiguration retrieveCourses()
	{
		System.out.println(" Url:"+configuration.getUrl());
		System.out.println(" name:"+configuration.getName());
		System.out.println(" Key:"+configuration.getKey());
		return  configuration;
	}
}
