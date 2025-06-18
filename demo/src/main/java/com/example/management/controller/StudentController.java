package com.example.management.controller;

import com.example.management.Repository.StudentRepository;
import com.example.management.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/Students")
    public List<Student> GetAllStudent(){
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    public Student GetStudentById(@PathVariable Long id){
        return studentRepository.findById(id).get();
    }

    public ResponseEntity<Student> CrateStudent(@RequestBody Student student){
        Student Create = studentRepository.save(student);
        return ResponseEntity.ok(Create);
    }
}
