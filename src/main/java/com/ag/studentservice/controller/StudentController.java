package com.ag.studentservice.controller;

import com.ag.studentservice.entity.Student;
import com.ag.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    @Autowired
    StudentRepository repository;

    @GetMapping("/students")
    @ResponseBody
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @GetMapping("/student")
    public Student getStudentById(@RequestParam Integer id) {
        return repository.findById(id).get();
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        student.getPhoneNumberList().forEach(phoneNumber -> phoneNumber.setStudent(student));
        return repository.save(student);
    }

}


