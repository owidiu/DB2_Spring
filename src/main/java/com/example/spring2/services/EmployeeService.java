package com.example.spring2.services;

import com.example.spring2.model.Employee;
import com.example.spring2.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    List<Employee> employees = new ArrayList<>();

    public List<Employee> getAllEmployees(){
        List<Employee> aux = new ArrayList<>();
        employeeRepository.findAll().iterator().forEachRemaining(aux::add);
        return aux;
    }

    public Employee addEmployee(Employee e){
        return employeeRepository.save(e);
    }

}
