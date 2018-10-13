package com.minkov.app.base;

public interface SetBase<T> {
    void add(T value);
    boolean contains(T value);

    void remove(T value);
    int size();
}
