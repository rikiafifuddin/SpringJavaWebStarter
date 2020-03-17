package com.demo.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
	private final UUID id;
	
	@NotBlank
	private final String name;
	
	private String address;
	private String job;
	private int salary;
	
	public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name, @JsonProperty("address") String address, @JsonProperty("job") String job, @JsonProperty("salary") int salary) {
		this.id=id;
		this.name=name;
		this.address = address;
		this.job=job;
		this.salary=salary;
	}
	
	public String getName() {
		return name;
	}

	public UUID getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public String getJob() {
		return job;
	}

	public int getSalary() {
		return salary;
	}

}
