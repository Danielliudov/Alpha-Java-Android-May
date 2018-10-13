package com.telerikacademy.springhibernatedemo.services;

import com.telerikacademy.springhibernatedemo.models.Employee;
import com.telerikacademy.springhibernatedemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Employee employee) {
        repository.create(employee);
    }

    @Override
    public List<Employee> getAll() {
        return repository.getAll();
    }

    @Override
    public Employee getById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<Employee> getByJobTitle(String jobTitle) {
        return repository.getByJobTitle(jobTitle);
    }

    @Override
    public void update(int id, Employee employee) {
        repository.update(id, employee);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}