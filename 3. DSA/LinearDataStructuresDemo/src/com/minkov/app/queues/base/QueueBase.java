package com.minkov.app.queues.base;

public interface QueueBase {
    void enqueue(int value);

    int dequeue();

    int peek();

    int size();

    boolean isEmpty();
}
