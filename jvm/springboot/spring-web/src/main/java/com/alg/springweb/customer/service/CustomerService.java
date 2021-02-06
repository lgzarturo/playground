package com.alg.springweb.customer.service;

import com.alg.springweb.customer.domain.Company;
import com.alg.springweb.customer.domain.Customer;
import com.alg.springweb.customer.repository.CustomerCrudRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerCrudRepository customerCrudRepository;
    private final CompanyService companyService;

    public CustomerService(CustomerCrudRepository customerCrudRepository, CompanyService companyService) {
        this.customerCrudRepository = customerCrudRepository;
        this.companyService = companyService;
    }

    public Customer create(String firstName, String lastName, String email, String companyName) {
        Company company = companyService
                .getByCompanyName(companyName)
                .orElse(null);

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        if (company != null) {
            customer.setCompany(company);
        }
        return customerCrudRepository.save(customer);
    }

    public List<Customer> getAll() {
        return (List<Customer>) customerCrudRepository.findAll();
    }

    public Customer getByEmail(String email) {
        return customerCrudRepository.findByEmail(email);
    }

    public List<Customer> getCustomersWithCompany() {
        return customerCrudRepository.findCustomersWithCompany();
    }
}
