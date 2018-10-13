package com.telerikacademy.isolationdemo.services;

import com.telerikacademy.isolationdemo.models.Employee;
import com.telerikacademy.isolationdemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> getAll() {
        return repository.getAll();
    }

    @Override
    public List<Employee> getByJobTitle(String jobTitle) {
        return getAll()
                .stream()
                .filter(e -> e.getJobTitle().equals(jobTitle))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getByJobTitleAndMinSalary(String jobTitle, BigDecimal minSalary) {
        return getByJobTitle(jobTitle)
                .stream()
                .filter(e -> e.getSalary().compareTo(minSalary) >= 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getByJobTitleAndMaxSalary(String jobTitle, BigDecimal maxSalary) {
        return getByJobTitle(jobTitle)
                .stream()
                .filter(e -> e.getSalary().compareTo(maxSalary) <= 0)
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal getMinSalaryByJobTitle(String jobTitle) {
        return getByJobTitle(jobTitle)
                .stream()
                .map(e -> e.getSalary())
                .min(BigDecimal::compareTo)
                .get();
    }

    @Override
    public BigDecimal getMaxSalaryByJobTitle(String jobTitle) {
        return getByJobTitle(jobTitle)
                .stream()
                .map(e -> e.getSalary())
                .max(BigDecimal::compareTo)
                .get();
    }
}