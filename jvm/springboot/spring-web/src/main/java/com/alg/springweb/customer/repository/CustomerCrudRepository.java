package com.alg.springweb.customer.repository;

import com.alg.springweb.customer.domain.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CustomerCrudRepository extends CrudRepository<Customer, UUID> {
    Customer findByEmail(String email);

    @Query("SELECT cu FROM Customer cu INNER JOIN Company co ON cu.company.id = co.id")
    List<Customer> findCustomersWithCompany();
}
