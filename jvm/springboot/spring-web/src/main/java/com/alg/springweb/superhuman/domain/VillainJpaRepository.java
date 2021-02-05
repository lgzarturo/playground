package com.alg.springweb.superhuman.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "villains", collectionResourceRel = "villains")
public interface VillainJpaRepository extends JpaRepository<Villain, Long> {
}
