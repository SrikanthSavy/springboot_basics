package com.shoda.rest.webservices.restful_web_servies.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	//@RequestMapping(method = RequestMethod.GET,path = "/hello-world")
	@GetMapping(path = "/hello-world")
	public String getHelloWorld()
	{
		return "Welcome to REST with SpringBoot!";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean getHelloWorldBean()
	{
		return new HelloWorldBean("Welcome from Bean");
	}
	
	//Path Variables - Learning
	///hello-world/path-variable/{name}
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean getHelloWorldBeanPath(@PathVariable String name)
	{
		return new HelloWorldBean("Welcome to SpringBoot REST, "+name);
	}
	

	
}
