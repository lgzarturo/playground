package com.alg.springweb.person.data;

import com.alg.springweb.person.domain.Person;
import com.alg.springweb.person.domain.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@AllArgsConstructor
@Component
public class PersonDataLoader {
	private final PersonRepository personRepository;

	@PostConstruct
	private void loadData() {
		this.personRepository.saveAll(List.of(
				new Person("Arturo López"),
				new Person("Carlos Vela"),
				new Person("Maria Gómez"),
				new Person("Alberto Gutierrez"),
				new Person("Diana Sanchez"),
				new Person("Juan Zapata")
		));
	}
}
