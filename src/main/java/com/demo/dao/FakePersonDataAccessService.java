package com.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import com.demo.model.Person;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{

	private static List<Person> DB = new ArrayList<>();
	
	@Override
	public int insertPerson(UUID id, Person person) {
		DB.add(new Person(id, person.getName(), person.getAddress(), person.getJob(), person.getSalary()));
		return 1;
	}
	@Override
	public List<Person> selectAllPerson() {
		return DB;
	}
	@Override
	public Optional<Person> selectPersonById(UUID id) {
		return DB.stream()
				.filter(person -> person.getId().equals(id))
				.findFirst();
	}
	@Override
	public int deletePersonById(UUID id) {
		Optional<Person> personMaybe = selectPersonById(id);
		if (personMaybe.isPresent()) {
			DB.remove(personMaybe.get());
			return 1;
		}
		return 0;
	}
	@Override
	public int updatePersonById(UUID id, Person update) {
		return selectPersonById(id)
				.map(person -> {
					int indexOfPersonToUpdate = DB.indexOf(person);
					if (indexOfPersonToUpdate >=0) {
						DB.set(indexOfPersonToUpdate,new Person(id, update.getName(), update.getAddress(), update.getJob(), update.getSalary()));
						return 1;
					}
					return 0;
				})
				.orElse(0);
	}
	@Override
	public List<Person> selectPersonByJob(String job){
		List<Person> personByJob = DB.stream().filter(person -> person.getJob().equals(job))
				.collect(Collectors.toList());
		return personByJob;
	}
	
	
	
	
	
}