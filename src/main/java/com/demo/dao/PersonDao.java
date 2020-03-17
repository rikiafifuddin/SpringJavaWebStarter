package com.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.demo.model.Person;

public interface PersonDao {
	
	int insertPerson(UUID id, Person person);
		
		default int insertPerson(Person person) {
			UUID id= UUID.randomUUID();
			return insertPerson(id,person);
		}
		
	List<Person> selectAllPerson();
	Optional<Person> selectPersonById(UUID id);
	List<Person> selectPersonByJob(String job);
	int deletePersonById(UUID id);
	int updatePersonById(UUID id, Person person);
}
