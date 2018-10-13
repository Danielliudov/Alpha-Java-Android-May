package com.minkov.app.lists.base;

public interface LinkedListBase {
    void addHead(int value);

    void addTail(int value);

    void deleteHead();

    void deleteTail();

    int getHead();

    int getTail();

    int size();
}
