package com.alg.springweb.customer.controller;

import com.alg.springweb.customer.domain.Customer;
import com.alg.springweb.customer.domain.dto.CustomerDTO;
import com.alg.springweb.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/customers")
    @ResponseBody
    public CustomerDTO create(String firstName,
                              String lastName,
                              String email,
                              String company) {
        Customer customer = customerService.create(firstName, lastName, email, company);
        return CustomerDTO.toCustomerDTO(customer);
    }

    @GetMapping(value = "/customers")
    @ResponseBody
    public List<CustomerDTO> getAll() {
        return customerService.getAll()
                .stream()
                .map(CustomerDTO::toCustomerDTO)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/customers", params = "email")
    @ResponseBody
    public CustomerDTO getByEmail(@RequestParam("email") String email) {
        Customer customer = customerService.getByEmail(email);
        return CustomerDTO.toCustomerDTO(customer);
    }

    @GetMapping(value = "/customers", params = "withCompanyOnly")
    @ResponseBody
    public List<CustomerDTO> getAllCustomersWithCompany(
            @RequestParam("withCompanyOnly") boolean withCompanyOnly
    ) {
        return customerService.getCustomersWithCompany()
                .stream()
                .map(CustomerDTO::toCustomerDTO)
                .collect(Collectors.toList());
    }
}
