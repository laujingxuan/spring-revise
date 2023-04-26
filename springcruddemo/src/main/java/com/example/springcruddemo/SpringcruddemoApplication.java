package com.example.springcruddemo;

import com.example.springcruddemo.dao.StudentDAO;
import com.example.springcruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringcruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			createStudent(studentDAO);

//			readStudent(studentDAO);
			
//			queryForAllStudents(studentDAO);

//			queryForStudentByLastName(studentDAO);
			
//			updateStudent(studentDAO);

//			updateAllLastName(studentDAO);

//			deleteById(studentDAO);

//			deleteByFirstName(studentDAO);
		};
	}

	private void deleteByFirstName(StudentDAO studentDAO) {
		int numDeleted = studentDAO.deleteByFirstName("Duff");
		System.out.println(numDeleted);
	}

	private void deleteById(StudentDAO studentDAO) {
		int studentId = 2;
		studentDAO.deleteById((studentId));
	}

	private void updateAllLastName(StudentDAO studentDAO) {
		String newLastName = "Lau";
		studentDAO.updateAllLastName("Lau");
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		Student student = studentDAO.findById(studentId);

		student.setFirstName("Scooby");
		studentDAO.update(student);
		System.out.println(student);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Doh");
		for (Student student: students){
			System.out.println(student);
		}
	}

	private void queryForAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		for (Student student: students){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student newStudent = new Student("Duff", "Doh", "john@hotmail.com");
		studentDAO.save(newStudent);

		int studentId = newStudent.getId();
		System.out.println("Student Id is " + studentId);

		Student student = studentDAO.findById(studentId);
		System.out.println(student);
	}

	private void createStudent(StudentDAO studentDAO) {
		Student newStudent = new Student("John", "Doh", "john@hotmail.com");
		studentDAO.save(newStudent);

		System.out.println("new student ID: " + newStudent.getId());
	}

}
