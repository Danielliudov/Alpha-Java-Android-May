package com.minkov.app.stacks.base;

public interface StackBase {
    int size();

    void push(int value);

    int pop();

    int peek();
}
