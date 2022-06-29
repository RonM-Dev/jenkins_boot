package com.ron.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

  List<Student> findByLastName(String lastName);
  
  List<Student> findByFirstName(String firstName);

  Student findById(long id);
}
