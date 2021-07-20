package com.aamer.springboot;

import com.aamer.springboot.dao.StudentRepository;
import com.aamer.springboot.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Configuration
public class StudentConfig {

    // @Bean tells spring 'here is an instance of this class, keep hold of it and give it back to me when i ask'
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {

                    Student s1 = new Student(1L, "John", LocalDate.of(1999,9,29), "john@gmail.com");
                    Student s2 = new Student(2L, "Jim" , LocalDate.of(2001,9,29), "jim@gmail.com");
                    Student s3 = new Student(3L, "David" , LocalDate.of(1989,6,29), "david@gmail.com");
                    Student s4 = new Student(4L, "Adam" , LocalDate.of(2009,1, 1), "adam@gmail.com");

                    studentRepository.saveAll(Arrays.asList(s1,s2,s3,s4));
        };
    }
}
