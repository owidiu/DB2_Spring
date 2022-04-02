package com.example.spring2.repositories;

import com.example.spring2.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
     List<Employee> getAllByName(String name);
}
