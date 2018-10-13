package com.telerikacademy.isolationdemo;

import com.telerikacademy.isolationdemo.models.Employee;
import com.telerikacademy.isolationdemo.repositories.EmployeeRepository;

import java.util.List;

public class FakeEmployeeRepository implements EmployeeRepository {
    private List<Employee> employees;

    public FakeEmployeeRepository(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public List<Employee> getAll() {
        return employees;
    }
}
