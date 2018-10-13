package com.telerikacademy.unittestingdemo;

import java.util.*;

public class ArrayStack implements Stack {
    private static final int DEFAULT_CAPACITY = 5;

    int[] data;
    int top;

    public ArrayStack() {
        data = new int[DEFAULT_CAPACITY];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int x) {
        top++;
        if (top == data.length) {
            resizeData();
        }
        data[top] = x;
    }

    public int pop() throws Exception {
        if (!isEmpty()) {
            return data[top--];
        }
        throw new Exception("Stack is empty.");
    }

    public int peek() throws Exception {
        if (!isEmpty()) {
            return data[top];
        }
        throw new Exception("Stack is empty.");
    }

    private void resizeData() {
        data = Arrays.copyOf(data, data.length * 2);
    }
}