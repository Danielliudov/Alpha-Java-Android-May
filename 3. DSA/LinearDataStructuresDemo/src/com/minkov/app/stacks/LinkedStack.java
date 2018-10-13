package com.minkov.app.stacks;

import com.minkov.app.stacks.base.StackBase;

public class LinkedStack implements StackBase {
    private StackNode head;
    private StackNode tail;
    private int size;

    public LinkedStack() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(int value) {
        StackNode newNode = new StackNode(value);
        if (head == null || tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }

        ++size;
    }

    @Override
    public int pop() {
        int valueToReturn = tail.getValue();

        StackNode newTail = tail.getPrev();
        newTail.setNext(null);
        tail = newTail;

        if (tail == null) {
            head = null;
        }

        --size;
        return valueToReturn;
    }

    @Override
    public int peek() {
        return tail.getValue();
    }

    private StackNode getNodeAtIndex(int index) {
        StackNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        return node;
    }


    class StackNode {
        private int value;
        private StackNode prev;
        private StackNode next;

        StackNode(int value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }

        StackNode getNext() {
            return next;
        }

        void setNext(StackNode next) {
            this.next = next;
        }

        StackNode getPrev() {
            return prev;
        }

        void setPrev(StackNode prev) {
            this.prev = prev;
        }

        int getValue() {
            return value;
        }

        void setValue(int value) {
            this.value = value;
        }
    }
}
