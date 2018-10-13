package com.telerikacademy.springhibernatedemo;

import com.telerikacademy.springhibernatedemo.models.Address;
import com.telerikacademy.springhibernatedemo.models.Employee;
import com.telerikacademy.springhibernatedemo.models.Project;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringHibernateDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringHibernateDemoApplication.class, args);
    }

    @Bean
    public SessionFactory sessionFactory() {
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Project.class)
                .buildSessionFactory();
    }
}
