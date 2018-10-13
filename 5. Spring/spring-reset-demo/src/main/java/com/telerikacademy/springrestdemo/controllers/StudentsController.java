package com.telerikacademy.springrestdemo.controllers;

import com.telerikacademy.springrestdemo.models.Student;
import com.telerikacademy.springrestdemo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentsController {
    private StudentService service;

    @Autowired
    public StudentsController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public void createStudent(@RequestBody Student student) {
        service.createStudent(student);
    }

    @GetMapping
    public List<Student> getStudents() {
        return service.getStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable int id, @RequestBody Student student) {
        service.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
    }
}
