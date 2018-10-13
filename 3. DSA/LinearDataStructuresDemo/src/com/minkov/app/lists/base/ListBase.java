package com.minkov.app.lists.base;

public interface ListBase {
    void add(int value);

    void insert(int index, int value);

    void delete(int value);

    void deleteAtIndex(int index);

    int size();

    int get(int index);

    void set(int index, int value);

    boolean contains(int value);

    int indexOf(int value);
    int indexOf(int value, int leftOfIndex);
}
