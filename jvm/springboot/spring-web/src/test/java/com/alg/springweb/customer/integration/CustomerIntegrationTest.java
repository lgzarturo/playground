package com.alg.springweb.customer.integration;

import com.alg.springweb.customer.domain.Customer;
import com.alg.springweb.customer.domain.dto.CustomerDTO;
import com.alg.springweb.customer.repository.CustomerCrudRepository;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class CustomerIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    private CustomerCrudRepository customerCrudRepository;

    @Before
    public void setUp() {
        customerCrudRepository.deleteAll();
    }

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void shouldReturnCustomerByEmail() {
        givenCustomer("Test1", "User1", "test1@example.com");
        givenCustomer("Test2", "User2", "test2@example.com");
        ResponseEntity<CustomerDTO> response = getCustomerByEmail("test2@example.com");
        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
        CustomerDTO result = response.getBody();
        assert result != null;
        MatcherAssert.assertThat(result.getFirstName(), CoreMatchers.is("Test2"));
        MatcherAssert.assertThat(result.getLastName(), CoreMatchers.is("User2"));
        MatcherAssert.assertThat(result.getEmail(), CoreMatchers.is("test2@example.com"));
        MatcherAssert.assertThat(result.getId(),CoreMatchers.is(CoreMatchers.not(CoreMatchers.nullValue())));
    }

    private ResponseEntity<CustomerDTO> getCustomerByEmail(String email) {
        final String url = String.format("http://localhost:%s/customers?email=%s", port, email);
        return restTemplate.getForEntity(url, CustomerDTO.class);
    }

    private Customer givenCustomer(String firstName, String lastName, String email) {
        return customerCrudRepository.save(new Customer(firstName, lastName, email, null));
    }
}
