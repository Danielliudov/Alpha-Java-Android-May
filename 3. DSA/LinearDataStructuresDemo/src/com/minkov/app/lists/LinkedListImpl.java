package com.minkov.app.lists;

import com.minkov.app.lists.base.LinkedListBase;
import com.minkov.app.lists.base.ListBase;

public class LinkedListImpl implements ListBase, LinkedListBase {
    private LinkedListNode head;
    private LinkedListNode tail;
    private int size;

    public LinkedListImpl() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(int value) {
        addTail(value);
    }

    @Override
    public void insert(int index, int value) {
        LinkedListNode node = new LinkedListNode(value);
        LinkedListNode prevNode = getNodeAtIndex(index);

        node.setPrev(
            prevNode.getPrev()
        );

        node.setNext(
            prevNode
        );

        prevNode.setPrev(
            node
        );

        ++size;
    }

    @Override
    public void delete(int value) {
        int index = indexOf(value);
        deleteAtIndex(index);
    }

    @Override
    public void deleteAtIndex(int index) {
        LinkedListNode nodeToDelete = getNodeAtIndex(index);

        nodeToDelete.getPrev()
            .setNext(
                nodeToDelete.getNext()
            );

        nodeToDelete.getNext()
            .setPrev(
                nodeToDelete.getPrev()
            );

        --size;
    }

    @Override
    public void addHead(int value) {
        LinkedListNode newNode = new LinkedListNode(value);
        if (head == null || tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            head.setPrev(newNode);
            newNode.setNext(head);
            head = newNode;
        }

        ++size;
    }

    @Override
    public void addTail(int value) {
        LinkedListNode newNode = new LinkedListNode(value);
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
    public void deleteHead() {
        LinkedListNode newHead = head.getNext();
        newHead.setPrev(null);
        head = newHead;

        if (head == null) {
            tail = null;
        }

        --size;
    }

    @Override
    public void deleteTail() {
        LinkedListNode newTail = tail.getPrev();
        newTail.setNext(null);
        tail = newTail;

        if (tail == null) {
            head = null;
        }

        --size;
    }

    @Override
    public int getHead() {
        return head.getValue();
    }

    @Override
    public int getTail() {
        return tail.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int get(int index) {
        return getNodeAtIndex(index)
            .getValue();
    }

    @Override
    public void set(int index, int value) {
        LinkedListNode node = getNodeAtIndex(index);

        node.setValue(value);
    }

    @Override
    public boolean contains(int value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(int value) {
        return indexOf(value, 0);
    }

    @Override
    public int indexOf(int value, int leftOfIndex) {
        LinkedListNode node = getNodeAtIndex(leftOfIndex);
        int index = leftOfIndex;

        while (node != null) {
            if (node.getValue() == value) {
                return index;
            }

            ++index;
            node = node.getNext();
        }

        return -1;
    }

    private LinkedListNode getNodeAtIndex(int index) {
        LinkedListNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        return node;
    }


    class LinkedListNode {
        private int value;
        private LinkedListNode prev;
        private LinkedListNode next;

        LinkedListNode(int value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }

        LinkedListNode getNext() {
            return next;
        }

        void setNext(LinkedListNode next) {
            this.next = next;
        }

        LinkedListNode getPrev() {
            return prev;
        }

        void setPrev(LinkedListNode prev) {
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
