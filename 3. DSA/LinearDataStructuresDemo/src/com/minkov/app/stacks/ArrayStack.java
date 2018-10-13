package com.minkov.app.stacks;

import com.minkov.app.stacks.base.StackBase;

import java.util.Arrays;

public class ArrayStack implements StackBase {

    private static final int INITIAL_CAPACITY = 4;
    private int size;
    private int capacity;
    private int[] values;

    public ArrayStack() {
        capacity = INITIAL_CAPACITY;
        values = new int[this.capacity];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(int value) {
        if (shouldResize()) {
            resize();
        }

        values[size] = value;
        ++size;
    }

    private void resize() {
        capacity *= 2;
        int[] oldValues = values;
        values = new int[capacity];
        size = 0;
        Arrays.stream(oldValues)
            .forEach(this::push);
    }

    private boolean shouldResize() {
        return size == capacity;
    }

    @Override
    public int pop() {
        if (size == 0) {
            throw new NullPointerException("The stack is empty");
        }
        int valueToReturn = values[size - 1];
        --size;
        return valueToReturn;
    }

    @Override
    public int peek() {
        return values[size - 1];
    }
}
