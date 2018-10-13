package com.minkov.app.lists;

import com.minkov.app.lists.base.ListBase;

import java.util.Arrays;

public class ArrayListImpl implements ListBase {

    private static final int INITIAL_CAPACITY = 4;
    private int capacity;
    private int size;
    private int[] values;

    public ArrayListImpl() {
        this.capacity = INITIAL_CAPACITY;
        this.size = 0;
        this.values = new int[this.capacity];
    }

    @Override
    public void add(int value) {
        if (shouldResize()) {
            resize();
        }

        this.values[size] = value;
        ++size;
    }

    @Override
    public void insert(int index, int value) {
        checkBounds(index);

        if (shouldResize()) {
            resize();
        }

        if (size == 0) {
            add(value);
            return;
        }

        System.arraycopy(values, index - 1, values, index, size + 1 - index);

        values[index] = value;
        ++size;
    }

    @Override
    public void delete(int value) {
        int index = indexOf(value);

        if (index < 0) {
            return;
        }

        deleteAtIndex(index);
    }

    @Override
    public void deleteAtIndex(int index) {
        checkBounds(index);

        System.arraycopy(values, index + 1, values, index, size - index);
        --size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int get(int index) {
        checkBounds(index);

        return values[index];
    }

    @Override
    public void set(int index, int value) {
        checkBounds(index);

        values[index] = value;
    }

    @Override
    public boolean contains(int value) {
        return indexOf(value) >= 0;
    }


    @Override
    public int indexOf(int value, int leftOfIndex) {
        int index = -1;
        for (int i = leftOfIndex; i < size; i++) {
            if (values[i] == value) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int indexOf(int value) {
        return indexOf(value, 0);
    }


    private void checkBounds(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void resize() {
        capacity *= 2;
        int[] oldValues = values;
        values = new int[capacity];
        size = 0;
        Arrays.stream(oldValues)
            .forEach(this::add);
    }

    private boolean shouldResize() {
        return size == capacity;
    }
}
