package com.telerikacademy.springhibernatedemo.repositories;

import com.telerikacademy.springhibernatedemo.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SqlEmployeeRepository implements EmployeeRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Employee employee) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> result = new ArrayList<>();
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.createQuery("from Employee").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Employee getById(int id) {
        Employee result = null;
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.get(Employee.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public List<Employee> getByJobTitle(String jobTitle) {
        List<Employee> result = new ArrayList<>();
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.createQuery("from Employee where jobTitle = :jobTitle")
                    .setParameter("jobTitle", jobTitle)
                    .list();
            session.getTransaction().commit();
        }
        return result;
    }

    @Override
    public void update(int id, Employee employee) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            Employee employeeToChange = session.get(Employee.class, id);

            employeeToChange.setFirstName(employee.getFirstName());
            employeeToChange.setLastName(employee.getLastName());
            employeeToChange.setJobTitle(employee.getJobTitle());

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {

    }
}
