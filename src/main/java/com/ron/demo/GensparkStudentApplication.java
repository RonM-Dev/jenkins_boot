package com.ron.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GensparkStudentApplication {
	
    private static final Logger log = LoggerFactory.getLogger(GensparkStudentApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GensparkStudentApplication.class, args);
	}
	
	  @Bean
	  public CommandLineRunner demo(StudentRepository repository) {
	    return (args) -> {
	      // save a few students
	      repository.save(new Student("Jack", "Black"));
	      repository.save(new Student("Kyle", "Gas"));
	      repository.save(new Student("Ian", "Black"));
	      repository.save(new Student("David", "Ducovny"));
	      repository.save(new Student("Michelle", "Pfieffer"));

	      // fetch all students
	      log.info("");
	      log.info("Students found with findAll():");
	      log.info("-------------------------------");
	      for (Student students : repository.findAll()) {
	        log.info(students.toString());
	      }

	      // fetch an individual student by ID
	      log.info("");
	      Student student = repository.findById(2L);
	      log.info("Student found with findById(2L):");
	      log.info(student.toString());
	      log.info("");

	      // fetch customers by first name
	      log.info("");
	      log.info("Student found with findByFirstName('Michelle'):");
	      log.info("--------------------------------------------");
	      repository.findByFirstName("Michelle").forEach(firstName -> {
	        log.info(firstName.toString());
	      });
	      
	      // fetch students by last name
	      log.info("\nStudent found with findByLastName('Black'):");
	      log.info("--------------------------------------------");
	      repository.findByLastName("Black").forEach(lastName -> {
	        log.info(lastName.toString());
	      });
	      log.info("");

	    };
	  }

}
