package com.demo.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Person;
import com.demo.service.PersonService;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
	private final PersonService personService;
	
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	@PostMapping
	public void addPerson(@Valid @NotNull @RequestBody Person person) {
		personService.addPerson(person);
	}
	@GetMapping 
	public List<Person> getAllPerson(){
		return personService.getAllPerson();
	}
	@GetMapping(path="id/{id}")
	public Person getPersonById(@PathVariable("id") UUID id) {
		return personService.getPersonById(id)
					.orElse(null);
	}
	@DeleteMapping(path="{id}")
	public void deletePersonById(@PathVariable("id") UUID id) {
		personService.deletePerson(id);
	}
	@PutMapping(path="{id}")
	public void updatePerson(@PathVariable("id")UUID id,@Valid @NotNull @RequestBody Person personToUpdate) {
		personService.updatePersen(id, personToUpdate);
	}
	@GetMapping(path= "job/{job}")
	public List<Person> getPersonByJob(@PathVariable("job") String job) {
		return personService.getPersonByJob(job);
	}
}
