package com.minkov.app.deques.base;

public interface DequeBase {
    int size();

    void addHead(int value);

    void deleteHead();

    int getHead();

    void addTail(int value);

    void deleteTail();

    int getTail();
}
