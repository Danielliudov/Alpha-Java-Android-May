package com.minkov.app.queues;

import com.minkov.app.queues.base.QueueBase;

public class ArrayQueue implements QueueBase {

    private static final int DEFAULT_INITIAL_CAPACITY = 8;
    private int[] values;

    private int capacity;
    private int size;
    private int tailIndex;
    private int headIndex;

    public ArrayQueue() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public ArrayQueue(int initialCapacity) {
        headIndex = 0;
        tailIndex = 0;
        size = 0;
        capacity = initialCapacity;
        values = new int[capacity];
    }

    @Override
    public void enqueue(int value) {
        if (shouldResize()) {
            resize();
        }
        values[tailIndex] = value;
        ++tailIndex;
        tailIndex %= capacity;
        ++size;
    }

    @Override
    public int dequeue() {
        int valueToReturn = values[headIndex];
        headIndex += 1;
        headIndex %= capacity;
        --size;
        return valueToReturn;
    }

    @Override
    public int peek() {
        return values[headIndex];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    private void resize() {
        int[] oldValues = values;
        int oldHeadIndex = headIndex;
        int oldTailIndex = tailIndex;
        int oldCapacity = capacity;
        capacity <<= 1;
        headIndex = 0;
        tailIndex = 0;
        size = 0;
        values = new int[capacity];
        while (oldHeadIndex != oldTailIndex) {
            enqueue(oldValues[oldHeadIndex]);

            oldHeadIndex += 1;
            oldHeadIndex %= oldCapacity;
        }
    }

    private boolean shouldResize() {
        return size == capacity;
    }
}
