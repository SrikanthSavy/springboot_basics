package com.in28minutes.spring.learn_spring_framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.in28minutes.spring.learn_spring_framework.enterprise.example.web.MyWebController;
import com.in28minutes.spring.learn_spring_framework.game.GameRunner;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		
		//MarioGame game = new MarioGame();
		//SuperContraGame game = new SuperContraGame();
		//PacmanGame game = new PacmanGame();
		//GameRunner runner = new GameRunner(game);
		//runner.run();
		
		context.getBean(GameRunner.class).run();
		
		MyWebController controller = context.getBean(MyWebController.class);
		System.out.println("MyWebController Called: SUM =="+controller.returnValueFromBusinessService());
		
	}

}
