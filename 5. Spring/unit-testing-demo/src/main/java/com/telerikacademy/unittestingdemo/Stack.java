package com.telerikacademy.unittestingdemo;

public interface Stack {
    boolean isEmpty();
    void push(int x);
    int pop() throws Exception;
    int peek() throws Exception;
}
