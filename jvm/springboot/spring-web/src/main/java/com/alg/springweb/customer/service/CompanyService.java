package com.alg.springweb.customer.service;

import com.alg.springweb.customer.domain.Company;
import com.alg.springweb.customer.repository.CompanyCrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyCrudRepository companyCrudRepository;

    public CompanyService(CompanyCrudRepository companyCrudRepository) {
        this.companyCrudRepository = companyCrudRepository;
    }

    public Optional<Company> getByCompanyName(String companyName) {
        return companyCrudRepository.findByCompanyNameIgnoreCase(companyName);
    }
}
