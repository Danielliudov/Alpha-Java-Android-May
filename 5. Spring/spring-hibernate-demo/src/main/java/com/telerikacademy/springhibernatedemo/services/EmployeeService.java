package com.telerikacademy.springhibernatedemo.services;

import com.telerikacademy.springhibernatedemo.models.Employee;

import java.util.List;

public interface EmployeeService {
    void create(Employee employee);
    List<Employee> getAll();
    Employee getById(int id);
    List<Employee> getByJobTitle(String jobTitle);
    void update(int id, Employee employee);
    void delete(int id);
}
