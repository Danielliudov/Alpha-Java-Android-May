package com.minkov.app.queues;

import com.minkov.app.queues.base.QueueBase;

public class LinkedQueue implements QueueBase {
    private QueueNode head;
    private QueueNode tail;
    private int size;

    @Override
    public void enqueue(int value) {
        QueueNode node = new QueueNode(value);
        if (head == null || tail == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }

        ++size;
    }

    @Override
    public int dequeue() {
        int valueToReturn = head.getValue();

        head = head.getNext();
        --size;

        return valueToReturn;
    }

    @Override
    public int peek() {
        return head.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    class QueueNode {
        private int value;
        private QueueNode next;

        public QueueNode(int value) {
            setValue(value);
            setNext(null);
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public QueueNode getNext() {
            return next;
        }

        public void setNext(QueueNode next) {
            this.next = next;
        }
    }
}
