package com.minkov.app.deques;

import com.minkov.app.deques.base.DequeBase;
import com.minkov.app.lists.LinkedListImpl;

public class LinkedDeque implements DequeBase {
    private LinkedListImpl list;

    public LinkedDeque() {
        list = new LinkedListImpl();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void addHead(int value) {
        list.addHead(value);
    }

    @Override
    public void deleteHead() {
        list.deleteHead();
    }

    @Override
    public int getHead() {
        return list.getHead();
    }

    @Override
    public void addTail(int value) {
        list.addTail(value);
    }

    @Override
    public void deleteTail() {
        list.deleteTail();
    }

    @Override
    public int getTail() {
        return list.getTail();
    }
}
