package com.alg.springweb.customer.repository;

import com.alg.springweb.customer.domain.Company;
import com.alg.springweb.customer.domain.Customer;
import org.assertj.core.util.Lists;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@DataJpaTest
@RunWith(SpringRunner.class)
class CustomerCrudRepositoryTest {

    public static final String ENUM_CRM = "EnumCRM";

    @Autowired
    private CompanyCrudRepository companyCrudRepository;
    @Autowired
    private CustomerCrudRepository customerCrudRepository;

    @Test
    public void shouldReturnAllCustomersWithCompany() {
        Customer customer1 = givenCustomer("Test1", "User1", "test1@example.com", enumCRMCompany());
        Customer customer2 = givenCustomer("Test2", "User2", "test2@example.com", enumCRMCompany());
        givenCustomer("Test3", "User3", "test3@example.com", null);
        List<Customer> result = customerCrudRepository.findCustomersWithCompany();
        MatcherAssert.assertThat(result, CoreMatchers.is(Lists.newArrayList(customer1, customer2)));
    }

    private Customer givenCustomer(String firstName, String lastName, String email, Company company) {
        return customerCrudRepository.save(new Customer(firstName, lastName, email, company));
    }

    private Company enumCRMCompany() {
        return companyCrudRepository.findByCompanyNameIgnoreCase(ENUM_CRM)
                .orElse(new Company(ENUM_CRM));
    }
}
