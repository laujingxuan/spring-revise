package com.example.springcruddemo.dao;

import com.example.springcruddemo.entity.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //Student is the entity name (Not the database table name)
        //lastName is the entity field (Not the database column name)
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student order by firstName desc", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student WHERE lastName=:lastName", Student.class);
        theQuery.setParameter("lastName", lastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void updateAllLastName(String lastName) {
        entityManager.createQuery("UPDATE Student SET lastName=:lastName").setParameter("lastName", lastName).executeUpdate();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteByFirstName(String firstName) {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student WHERE firstName=:firstName").setParameter("firstName", firstName).executeUpdate();
        return numRowsDeleted;
    }
}
