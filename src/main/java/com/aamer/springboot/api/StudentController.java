package com.aamer.springboot.api;

import com.aamer.springboot.model.Student;
import com.aamer.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;


// api layer - endpoints exposed here
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void findStudent(@RequestBody Student student){
       studentService.findStudent(student);
    }

    @PostMapping(path = "add")
    public void addNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    // @RequestParam : used to get request parameters from the URL, also known as query string
    // @PathVariable : extracts the data right from the URI
    @PutMapping(path = "{id}")
    public void updateStudent(@PathVariable @NotNull Long id,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) {

        studentService.updateStudent(id, name, email);
    }

}
