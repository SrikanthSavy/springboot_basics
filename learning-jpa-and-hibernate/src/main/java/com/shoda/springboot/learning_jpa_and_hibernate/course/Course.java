package com.shoda.springboot.learning_jpa_and_hibernate.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity 					//or   @Entity(name = "Course_TableName")
public class Course {
	
	@Id						//Define which one is "Primary key"
	private int id;
	@Column					// Coloum to field mapping. NOte: You can use @Column(name="table_field_name")
	private String name;
	@Column
	private String author;
	
	public Course() {
		
	}

	public Course(int id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	

	
	

}
