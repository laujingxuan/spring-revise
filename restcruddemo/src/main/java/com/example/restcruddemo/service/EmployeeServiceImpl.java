package com.example.restcruddemo.service;

import com.example.restcruddemo.dao.EmployeeDAO;
import com.example.restcruddemo.dao.EmployeeRepository;
import com.example.restcruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

//    private EmployeeDAO employeeDAO;
    private EmployeeRepository employeeRepository;

//    @Autowired
//    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
//        this.employeeDAO = employeeDAO;
//    }

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
//        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;
        if (result.isPresent()){
            employee = result.get();
        } else {
            throw new RuntimeException("Did not find employeeId: " + id);
        }
        return employee;
//        return employeeDAO.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
//        return employeeDAO.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
//        employeeDAO.deleteById(id);
    }

    @Override
    public Employee findByFirstNameLastName(String firstName, String lastName) {
        return employeeRepository.findByFirstNameAndLastName(firstName, lastName);
    }
}
