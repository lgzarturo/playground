package com.alg.springweb.person.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "people", collectionResourceRel = "people")
public interface PersonJpaRepository extends JpaRepository<Person, Long> {
}
