package com.alg.springweb.person.controller;

import com.alg.springweb.person.domain.Person;
import com.alg.springweb.person.domain.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/people")
public class PersonController {
	private final PersonRepository personRepository;

	public PersonController(PersonRepository personRepository) {
		this.personRepository = personRepository;
		this.personRepository.saveAll(List.of(
				new Person("Arturo"),
				new Person("Carlos"),
				new Person("Maria"),
				new Person("Alberto"),
				new Person("Diana")
		));
	}

	@GetMapping
	Iterable<Person> getPeople() {
		return personRepository.findAll();
	}

	@GetMapping("/{id}")
	Optional<Person> getPersonById(@PathVariable Long id) {
		return personRepository.findById(id);
	}

	@PostMapping
	Person create(@RequestBody Person person) {
		return personRepository.save(person);
	}

	@PutMapping("/{id}")
	ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person person) {
		return (!personRepository.existsById(id))
				? new ResponseEntity<>(personRepository.save(person), HttpStatus.CREATED)
				: new ResponseEntity<>(personRepository.save(person), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	void delete(@PathVariable Long id) {
		personRepository.deleteById(id);
	}
}
