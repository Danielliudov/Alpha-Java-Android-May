package com.telerikacademy.springhibernatedemo.repositories;

import com.telerikacademy.springhibernatedemo.models.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@Repository
public class InMemoryEmployeeRepository implements EmployeeRepository {
    private List<Employee> employees = new ArrayList<>();

    public InMemoryEmployeeRepository() {
        employees.add(new Employee(1, "Petar", "Petrov", "Software Engineer"));
        employees.add(new Employee(2, "Ivan", "Ivanov", "QA Engineer"));
    }

    @Override
    public void create(Employee employee) {
        employees.add(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employees;
    }

    @Override
    public Employee getById(int id) {
        return getEmployee(id);
    }

    @Override
    public List<Employee> getByJobTitle(String jobTitle) {
        return employees.stream()
                .filter(e -> e.getJobTitle().equals(jobTitle))
                .collect(Collectors.toList());
    }

    @Override
    public void update(int id, Employee employee) {
        Employee e = getEmployee(id);
        int index = employees.indexOf(e);
        employees.set(index, employee);
    }

    @Override
    public void delete(int id) {
        Employee e = getEmployee(id);
        employees.remove(e);
    }

    private Employee getEmployee(int id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Employee with id %d not found", id)));
    }
}
