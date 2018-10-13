package com.minkov.app.queues;

import com.minkov.app.lists.LinkedListImpl;
import com.minkov.app.lists.base.LinkedListBase;
import com.minkov.app.queues.base.QueueBase;

public class ListQueue implements QueueBase {
    private LinkedListBase list;

    public ListQueue() {
        list = new LinkedListImpl();
    }

    @Override
    public void enqueue(int value) {
        list.addTail(value);
    }

    @Override
    public int dequeue() {
        int valueToReturn = list.getHead();
        list.deleteHead();
        return valueToReturn;
    }

    @Override
    public int peek() {
        return list.getHead();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
