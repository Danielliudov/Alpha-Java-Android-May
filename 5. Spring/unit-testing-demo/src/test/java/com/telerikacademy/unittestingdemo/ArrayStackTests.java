package com.telerikacademy.unittestingdemo;

import org.junit.*;

public class ArrayStackTests {

    @Before
    public void initTest() {
        System.out.println("Init test.");
    }

    @After
    public void cleanTest() {
        System.out.println("Clean test.");
    }

    @BeforeClass
    public static void initAllTests() {
        System.out.println("Init all tests.");
    }

    @AfterClass
    public static void cleanAllTests() {
        System.out.println("Clean all tests.");
    }

    @Test
    public void isEmpty_Should_ReturnTrue_When_StackEmpty() {
        System.out.println("Test empty stack.");
        // Arrange
        Stack s = new ArrayStack();

        // Act
        boolean isEmpty = s.isEmpty();

        // Assert
        Assert.assertTrue("New stack should be empty.", isEmpty);
    }

    @Test
    public void isEmpty_Should_ReturnFalse_When_StackNotEmpty() {
        System.out.println("Test not empty stack.");
        // Arrange
        Stack s = new ArrayStack();
        s.push(1);

        // Act + Assert
        Assert.assertFalse("Stack with element should not be empty", s.isEmpty());
    }

    @Test(expected = Exception.class)
    public void pop_Should_ThrowException_When_StackEmpty() throws Exception {
        // Arrange
        Stack s = new ArrayStack();

        // Act
        s.pop();
    }
}
