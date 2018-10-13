package com.minkov.app.base;

import java.util.List;
import java.util.function.Consumer;

public interface BinarySearchTreeBase<T extends Comparable<T>> {
    void add(T value);

    boolean contains(T value);

    void remove(T value);

    T search(T value);

    void traverse(Consumer<T> action);

}
