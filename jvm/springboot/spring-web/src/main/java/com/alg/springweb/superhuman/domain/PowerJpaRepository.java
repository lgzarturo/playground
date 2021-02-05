package com.alg.springweb.superhuman.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "powers", collectionResourceRel = "powers")
public interface PowerJpaRepository extends JpaRepository<Power, Long> {
}
