package com.shoda.springboot.learning_jpa_and_hibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoda.springboot.learning_jpa_and_hibernate.course.Course;

public interface CourseSpringDataJpaRespository extends JpaRepository<Course, Integer> {
	
	//define custom methods to fetch records from Course table
	//NOTE:  Method name should be findBy+Fieldname 
	// Using "author" field 
	public List<Course> findByAuthor(String author);
	
	// Using "name" field
	public List<Course> findByName(String name);
	
	

}
