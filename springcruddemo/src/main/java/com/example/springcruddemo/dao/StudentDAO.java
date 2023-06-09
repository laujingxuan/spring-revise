package com.example.springcruddemo.dao;

import com.example.springcruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student theStudent);

    void updateAllLastName(String lastName);

    void deleteById(int id);

    int deleteByFirstName(String firstName);
}
