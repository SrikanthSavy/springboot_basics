package com.shoda.springboot.learning_jpa_and_hibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.shoda.springboot.learning_jpa_and_hibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRespository {

	@PersistenceContext     		// Or Use cloud use @Autowired tooo , this one is more specific 
	EntityManager entityManager;
	
	
	//insert(course)
	public void insert(Course course)
	{
		entityManager.merge(course);  // This one line is used for Inserting "Course Object" as a Record in Course Table
	}
	
	//SelectById(int id)
	public Course selectById(int id)
	{ 
		return entityManager.find(Course.class,id);   // find method takes , entity-class and primaryKey
	}
	
	// Delete By id(int id)
	public void deleteById(int id)
	{
		//step1 - Find course to delete
		Course course = entityManager.find(Course.class,id);
		
		//delete/Remove it from the Table
		entityManager.remove(course);
	}
	
	
}
