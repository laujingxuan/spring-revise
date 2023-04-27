package com.example.restcruddemo.service;

import com.example.restcruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);

    Employee findByFirstNameLastName(String firstName, String lastName);
}
