package com.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.demo.model.Person;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao{

	@Override
	public int insertPerson(UUID id, Person person) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Person> selectAllPerson() {
		// TODO Auto-generated method stub
//		return List.of(new Person(UUID.randomUUID(),"asdf", "asdasda", "sdasdasd", 1234));
		return null;
	}

	@Override
	public Optional<Person> selectPersonById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> selectPersonByJob(String job) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deletePersonById(UUID id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePersonById(UUID id, Person person) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}