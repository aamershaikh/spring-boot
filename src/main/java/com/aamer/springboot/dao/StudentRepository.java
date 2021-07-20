package com.aamer.springboot.dao;

import com.aamer.springboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {

    // this will translate to a SQL statement. Method Query
    Optional<Student> findStudentById(Long Id);

    List<Student> findAll();

    @Override
    Student save(Student s);

    // Alternate way of Method query (findStudentById). Example of JPQL
    @Query("SELECT s FROM Student s where s.email= ?1")
    Optional<Student> findStudentByEmail(String email);

}
