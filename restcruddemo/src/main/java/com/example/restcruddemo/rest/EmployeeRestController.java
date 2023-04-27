package com.example.restcruddemo.rest;

import com.example.restcruddemo.dao.EmployeeDAO;
import com.example.restcruddemo.dao.EmployeeDAOImpl;
import com.example.restcruddemo.entity.Employee;
import com.example.restcruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if (employee == null){
            throw new RuntimeException("Employee id is not found: " + employeeId);
        }
        return employee;
    }

    @GetMapping("/employee/{firstName}/{lastName}")
    public Employee getEmployeeByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName){
        Employee employee = employeeService.findByFirstNameLastName(firstName, lastName);
        if (employee == null){
            throw new RuntimeException("Employee not found");
        }
        return employee;
    }

    @PostMapping("employee")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @PutMapping("employee")
    public Employee updateEmployee(@RequestBody Employee employee){
        if (employee.getId() == 0){
            // can return error in real scenario
            return null;
        }
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @DeleteMapping("employee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee dbEmployee = employeeService.findById(employeeId);

        if (dbEmployee == null){
            throw new RuntimeException("Employee id is not found: " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employeeId: " + employeeId;
    }
}
