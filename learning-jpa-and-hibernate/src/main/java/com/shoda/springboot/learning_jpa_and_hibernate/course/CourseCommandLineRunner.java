package com.shoda.springboot.learning_jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.shoda.springboot.learning_jpa_and_hibernate.course.jdbc.CourseJdbcRepository;
import com.shoda.springboot.learning_jpa_and_hibernate.course.jpa.CourseJpaRespository;
import com.shoda.springboot.learning_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRespository;
@Component // So spring content can pick this up when @ComponentScan
public class CourseCommandLineRunner implements CommandLineRunner {

	//Get our repository and use insert() inside run(){}
//	@Autowired
//	private CourseJdbcRepository repository;
	
/*	@Autowired
	private CourseJpaRespository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		repository.insert(new Course(101,"Lean AWS!-JPA","Shoda1"));
		repository.insert(new Course(102,"Lean SpringBoot!-JPA","Shoda2"));
		repository.insert(new Course(103,"Lean MicroServices!-JPA","Shoda3"));
		
		System.out.println("Course 101===="+  repository.selectById(101));
		System.out.println("Course 102===="+repository.selectById(102));
		System.out.println("Course 103===="+repository.selectById(103));
		
		repository.deleteById(102);
		
		
	}
	
*/
//NOTE: SpringDataJPA implementation Changes
	
	@Autowired
	private CourseSpringDataJpaRespository repository;
	
	@Override
	public void run(String... args) throws Exception {
		//repository.insert(new Course(103,"Lean MicroServices!-JPA","Shoda3"));
		//"save" instead of "insert"
		repository.save(new Course(101,"AWS","Shoda"));
		repository.save(new Course(102,"SpringBoot","Shoda"));
		repository.save(new Course(103,"MicroServices","Shoda3"));
		
		//		System.out.println("Course 103===="+repository.selectById(103));
		// findeById() instead of selectById()
		System.out.println("Course 101===="+  repository.findById(101));
		System.out.println("Course 102===="+repository.findById(102));
		System.out.println("Course 102===="+repository.findById(102));
		
		//repository.deleteById(102);
		
		System.out.println("SHODa Authored Courses:"+repository.findByAuthor("Shoda"));
		System.out.println("Course Name AWS:"+repository.findByName("AWS"));
		
	}
	
	

}
