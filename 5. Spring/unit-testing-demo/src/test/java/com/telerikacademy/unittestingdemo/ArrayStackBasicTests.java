package com.telerikacademy.unittestingdemo;

public class ArrayStackBasicTests {
    public static void main(String[] args) {
        ArrayStackBasicTests tests = new ArrayStackBasicTests();

        tests.stackIsEmptyWhenCreated();
        tests.stackIsNotEmptyWhenItemAdded();
    }

    public void stackIsEmptyWhenCreated() {
        Stack s = new ArrayStack();

        if (s.isEmpty()) {
            System.out.println("Pass - New stack is empty");
        } else {
            System.out.println("Fail - New stack is empty");
        }
    }

    public void stackIsNotEmptyWhenItemAdded() {
        Stack s = new ArrayStack();
        s.push(1);

        if (s.isEmpty()) {
            System.out.println("Fail - Stack with item is not empty");
        } else {
            System.out.println("Pass - Stack with item is not empty");
        }
    }
}
