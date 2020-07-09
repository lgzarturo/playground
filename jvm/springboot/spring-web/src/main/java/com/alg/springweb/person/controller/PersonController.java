package com.alg.springweb.person.controller;

import com.alg.springweb.person.domain.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/people")
public class PersonController {
	private List<Person> people = new ArrayList<>();

	public PersonController() {
		this.people.addAll(List.of(
				new Person("Arturo"),
				new Person("Carlos"),
				new Person("Maria"),
				new Person("Alberto"),
				new Person("Diana")
		));
	}

	@GetMapping
	Iterable<Person> getPeople() {
		return people;
	}

	@GetMapping("/{id}")
	Optional<Person> getPersonById(@PathVariable String id) {
		for (Person person : people) {
			if (person.getId().equals(id)) {
				return Optional.of(person);
			}
		}
		return Optional.empty();
	}

	@PostMapping
	Person create(@RequestBody Person person) {
		people.add(person);
		return person;
	}

	@PutMapping("/{id}")
	Person update(@PathVariable String id, @RequestBody Person person) {
		int indexPerson = -1;
		for (Person persistedPerson : people) {
			if (persistedPerson.getId().equals(id)) {
				indexPerson = people.indexOf(persistedPerson);
				people.set(indexPerson, person);
			}
		}
		return (indexPerson == -1) ? create(person) : person;
	}

	@DeleteMapping("/{id}")
	void delete(@PathVariable String id) {
		people.removeIf(person -> person.getId().equals(id));
	}
}
