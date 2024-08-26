package com.shoda.rest.webservices.restful_web_servies.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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

	//I18N- IMPLMENTATION -START
	//for Accessing "messages.properties" for I18n 
	private MessageSource messageSource;
	
	//constructor injection
	public HelloWorldController(MessageSource messageSource)
	{
		this.messageSource = messageSource;
	}
	
	//Internationailation- I18m - implementation
	@GetMapping(path = "/hello-world-message-i18n")
	public String getHelloWorldMessage()
	{
		Locale locale = LocaleContextHolder.getLocale();// Get locale from Request "Accept-language: nl" 
		return  messageSource.getMessage("good.morning.message", null, "Default Good Morning", locale);
	}
	//I18N- IMPLMENTATION -END
	
	
}
