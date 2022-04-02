package com.example.spring2.controllers;

import com.example.spring2.dto.CustomerDTO;
import com.example.spring2.model.Customer;
import com.example.spring2.services.CustomerService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() { return customerService.getAllCustomers(); }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Integer id) {
        return customerService.getById(id);
    }

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        customerService.insert(customer);
        //System.out.println(customer.getOrders().toString());
        return customer;
    }

    @PostMapping("/customers-dto")
    public Customer createCustomerDTO(@RequestBody CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO.getName(), customerDTO.getOrders());
        return customerService.insert(customer);
    }


    @DeleteMapping("/customers")
    public void deleteCustomer(@RequestBody Customer customer) {
        customerService.delete(customer);
    }

    @PostMapping("/customers/update")
    public Customer updateCustomer(@RequestBody Customer customer) {
        customerService.update(customer);
        return customer;
    }
}
