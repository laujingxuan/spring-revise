package com.example.restcontroller.rest;

import com.example.restcontroller.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentRestController {
    private List<Student> students;

    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        Student first = new Student("first", "firstName");
        Student second = new Student("second", "secondName");
        students.add(first);
        students.add(second);
    }

    @GetMapping("/list")
    public List<Student> getStudentList(){
        return students;
    }

    // By default, param name and path variable name should match
    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        if (studentId  >= students.size() || studentId < 0){
            throw new StudentNotFoundException("Student Id is not found - " + studentId);
        }

        return students.get(studentId);
    }

//    //Will catch studentNotFoundException
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
//        StudentErrorResponse err = new StudentErrorResponse();
//        err.setStatus(HttpStatus.NOT_FOUND.value());
//        err.setMessage((exc.getMessage()));
//        err.setTimeStamp((System.currentTimeMillis()));
//
//        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
//    }
//
//    // To catch any other exception
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
//        StudentErrorResponse err = new StudentErrorResponse();
//        err.setStatus(HttpStatus.BAD_REQUEST.value());
//        err.setMessage((exc.getMessage()));
//        err.setTimeStamp((System.currentTimeMillis()));
//
//        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
//    }
}
