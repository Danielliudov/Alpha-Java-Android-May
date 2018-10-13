package com.telerikacademy.isolationdemo.controllers;

import com.telerikacademy.isolationdemo.models.Employee;
import com.telerikacademy.isolationdemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeesRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeesRestController(EmployeeService service) {
        this.employeeService = service;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getAll();
    }
}
