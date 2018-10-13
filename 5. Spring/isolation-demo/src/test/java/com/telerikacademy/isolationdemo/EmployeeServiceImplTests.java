package com.telerikacademy.isolationdemo;

import com.telerikacademy.isolationdemo.models.Employee;
import com.telerikacademy.isolationdemo.repositories.EmployeeRepository;
import com.telerikacademy.isolationdemo.services.EmployeeService;
import com.telerikacademy.isolationdemo.services.EmployeeServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTests {
    @Mock
    EmployeeRepository mockRepository;

    @InjectMocks
    EmployeeServiceImpl service;

    List<Employee> defaultTestInput = Arrays.asList(
            new Employee(
                    "FirstName1",
                    "LastName1",
                    "JobTitle1",
                    BigDecimal.valueOf(100),
                    new Date(2018, 1, 1)),
            new Employee(
                    "FirstName2",
                    "LastName2",
                    "JobTitle2",
                    BigDecimal.valueOf(100),
                    new Date(2018, 1, 1)),
            new Employee(
                    "FirstName3",
                    "LastName3",
                    "JobTitle3",
                    BigDecimal.valueOf(100),
                    new Date(2018, 1, 1)));

    @Test
    public void getByJobTitle_Should_ReturnMatchingEmployees_When_MatchExist_WithFakeObject() {
        // Arrange
        EmployeeRepository fakeRepository = new FakeEmployeeRepository(defaultTestInput);
        EmployeeService service = new EmployeeServiceImpl(fakeRepository);

        // Act
        List<Employee> result = service.getByJobTitle("JobTitle2");

        // Assert
        Employee employee = result.get(0);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("JobTitle2", employee.getJobTitle());
    }

    @Test
    public void getByJobTitle_Should_ReturnMatchingEmployees_When_MatchExist_WithMockito() {
        // Arrange
        Mockito.when(mockRepository.getAll())
                .thenReturn(defaultTestInput);

        // Act
        List<Employee> result = service.getByJobTitle("JobTitle2");

        // Assert
        Employee employee = result.get(0);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("JobTitle2", employee.getJobTitle());
    }
}
