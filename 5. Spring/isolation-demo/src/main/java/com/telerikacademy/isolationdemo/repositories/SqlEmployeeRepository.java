package com.telerikacademy.isolationdemo.repositories;

import com.telerikacademy.isolationdemo.models.Employee;
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
}
