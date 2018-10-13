package com.telerikacademy.isolationdemo.repositories;

import com.telerikacademy.isolationdemo.models.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> getAll();
}
