package com.alg.springweb.customer.repository;

import com.alg.springweb.customer.domain.Company;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;


public interface CompanyCrudRepository extends CrudRepository<Company, UUID> {
    Optional<Company> findByCompanyNameIgnoreCase(String companyName);
}
