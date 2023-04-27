package com.example.restcruddemo.dao;

import com.example.restcruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE e.firstName=:firstName AND e.lastName=:lastName")
    Employee findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
