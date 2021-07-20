package com.aamer.springboot.service;


import com.aamer.springboot.dao.StudentRepository;
import com.aamer.springboot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
// @Component
public class StudentService {

    private final StudentRepository studentRepository;


    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void findStudent(Student student) {
        System.out.println(student);
        if(studentRepository.findStudentById(student.getId()) != null){
            throw new IllegalStateException("id taken");
        }
        studentRepository.save(student);
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    // @Transactional uses the setters defined in the POJO for consturcting the insert query
    @Transactional
    public void updateStudent(Long id, String name, String email) {
         Student student = studentRepository.findStudentById(id).orElseThrow(() -> new IllegalStateException("student does not exists"));
         // set new name as name
         student.setName(name);

         // set new email as email
         student.setEmail(email);
    }
}
