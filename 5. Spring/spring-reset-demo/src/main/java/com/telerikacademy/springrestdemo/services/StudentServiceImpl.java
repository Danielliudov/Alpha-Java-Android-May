package com.telerikacademy.springrestdemo.services;

import com.telerikacademy.springrestdemo.models.Student;
import com.telerikacademy.springrestdemo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createStudent(Student student) {
        repository.createStudent(student);
    }

    @Override
    public List<Student> getStudents() {
        return repository.getStudents();
    }

    @Override
    public Student getStudentById(int id) {
        return repository.getStudentById(id);
    }

    @Override
    public void updateStudent(int id, Student student) {
        repository.updateStudent(id, student);
    }

    @Override
    public void deleteStudent(int id) {
        repository.deleteStudent(id);
    }
}
