package com.alg.springweb.customer.domain.dto;

import com.alg.springweb.customer.domain.Company;
import com.alg.springweb.customer.domain.Customer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class CustomerDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String companyName;

    @JsonCreator
    public CustomerDTO(
            @JsonProperty("id") UUID id,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("email") String email,
            @JsonProperty("companyName") String companyName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.companyName = companyName;
    }

    public static CustomerDTO toCustomerDTO(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                toCompanyName(customer.getCompany())
        );
    }

    private static String toCompanyName(Company company) {
        return company != null ? company.getCompanyName() : "";
    }
}
