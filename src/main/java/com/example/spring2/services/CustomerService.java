package com.example.spring2.services;

import com.example.spring2.model.Customer;
import com.example.spring2.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer getById(Integer id) {
        return customerRepository.findById(id).get();
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().iterator().forEachRemaining(customers::add);
        return customers;
    }

    public Customer insert(Customer customer) {
        return customerRepository.save(customer);
    }

    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

}
