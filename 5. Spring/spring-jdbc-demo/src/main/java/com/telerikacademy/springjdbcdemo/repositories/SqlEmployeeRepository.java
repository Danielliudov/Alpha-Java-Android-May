package com.telerikacademy.springjdbcdemo.repositories;

import com.telerikacademy.springjdbcdemo.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SqlEmployeeRepository implements EmployeeRepository {
    @Autowired
    private ConnectionHelper connectionHelper;

    @Override
    public void create(Employee employee) {

    }

    @Override
    public List<Employee> getAll() {
        String query = "select EmployeeID, FirstName, LastName, JobTitle from employees";
        List<Employee> employees = new ArrayList<>();
        try (
                Connection connection = connectionHelper.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        ) {
            employees = readData(resultSet);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return employees;
    }

    @Override
    public Employee getById(int id) {
        return null;
    }

    @Override
    public List<Employee> getByJobTitle(String jobTitle) {
        String query =
                "select EmployeeID, FirstName, LastName, JobTitle " +
                        "from employees " +
                        "where JobTitle = ?";

        List<Employee> employees = new ArrayList<>();
        try (
                Connection connection = connectionHelper.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, jobTitle);
            try (
                    ResultSet resultSet = statement.executeQuery();
            ) {
                employees = readData(resultSet);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return employees;
    }

    @Override
    public void update(int id, Employee employee) {

    }

    @Override
    public void delete(int id) {

    }

    private List<Employee> readData(ResultSet employeesData) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        while (employeesData.next()) {
            Employee e = new Employee(
                    employeesData.getInt("EmployeeID"),
                    employeesData.getString("FirstName"),
                    employeesData.getString("LastName"),
                    employeesData.getString("JobTitle")
            );
            employees.add(e);
        }
        return employees;
    }
}
