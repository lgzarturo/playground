package com.alg.springweb.superhuman.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "heroes", collectionResourceRel = "heroes")
public interface HeroJpaRepository extends JpaRepository<Hero, Long> {
}
