package com.in28minutes.spring.learn_spring_framework.game;

import org.springframework.stereotype.Component;

@Component
public class MarioGame implements GamingConsole{
	
	public void up()
	{
		System.out.println("Jump");
	}
	
	public void down()
	{
		System.out.println("sit down");
	}
	
	public void left()
	{
		System.out.println("Break");
	}
	
	public void right()
	{
		System.out.println("Accelerate");
	}
	

}
