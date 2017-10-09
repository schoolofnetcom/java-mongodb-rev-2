package com.schoolofnet.SpringMongoDB;

import org.springframework.data.annotation.Id;

public class Task {

	@Id
	private String id;
	private String name;

	public Task() {
		// TODO Auto-generated constructor stub
	}
	
	public Task(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.id + " " + this.name;
	}
}
