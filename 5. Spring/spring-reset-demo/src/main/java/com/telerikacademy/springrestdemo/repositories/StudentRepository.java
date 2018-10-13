package com.telerikacademy.springrestdemo.repositories;

import com.telerikacademy.springrestdemo.models.Student;

import java.util.List;

public interface StudentRepository {
    void createStudent(Student student);
    List<Student> getStudents();
    Student getStudentById(int id);
    void updateStudent(int id, Student student);
    void deleteStudent(int id);
}
