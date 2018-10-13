package com.minkov.app.base;

public interface BinaryHeapBase<T extends Comparable<T>> {
    void push(T value);

    T deleteBest();

    T getBest();

    int size();
}
