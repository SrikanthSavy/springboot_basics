package com.shoda.springboot.learning_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shoda.springboot.learning_jpa_and_hibernate.course.Course;

@Repository
public class CourseJdbcRepository {
	//Static Query to execute
	private static String INSERT_QUERY_OLD = 
				""" 
					insert into course (id,name,author) values ( 100, 'Learn AWS!','Srikanth Shoda'); 
				""";
	private static String INSERT_QUERY = 
				""" 
					insert into course (id,name,author) values ( ?, ?,?);  
				""";
	private static String DELETE_QUERY = 
				""" 
					delete from course where id=?;  
				""";
	
	private static String SELECT_QUERY = 
				""" 
					select * from course where id=?;  
				""";
	
	
	
	
	@Autowired
	JdbcTemplate springJdbcTemplate;  // Main class to use for Insert/Update/Delete from Reposity (h2 DB)
	
	
	// Method to dynamically pass Values inside "Insert Query"
	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, course.getId(),course.getName(),course.getAuthor());  // Executing our Query 
	}
	
	public void insertOld() {
		springJdbcTemplate.update(INSERT_QUERY);  // Executing our Query 
		//Question ? : How to invoke this code on Spring Application Context startup
		// Solution : CommandLineRunner (interface) run(String... args){}
	}
	
	//Delete a Course by given "id" from Course Table
	public void deleteById(int id)
	{
		int noOfRowsAffected = springJdbcTemplate.update(DELETE_QUERY, id);
		if(noOfRowsAffected==1)
			System.out.println("Course Deleted for Id="+id);
	}
	
	//Select * course for given Id
	public Course selectById(int id)
	{
		//ResultSet --> Course Bean ==Using RowMapper => BeanPropertyRowMapper 
		return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
		//NOTE: as the field names in Table and BEan are same , we dont have to map indiviually
	}
	
	
	
}
