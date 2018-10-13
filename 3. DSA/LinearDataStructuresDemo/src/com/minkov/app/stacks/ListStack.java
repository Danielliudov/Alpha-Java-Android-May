package com.minkov.app.stacks;

import com.minkov.app.lists.ArrayListImpl;
import com.minkov.app.lists.base.ListBase;
import com.minkov.app.stacks.base.StackBase;

public class ListStack implements StackBase {
    private ListBase list;

    public ListStack() {
        list = new ArrayListImpl();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void push(int value) {
        list.add(value);
    }

    @Override
    public int pop() {
        int valueToReturn = list.get(list.size() - 1);
        list.deleteAtIndex(list.size() - 1);
        return valueToReturn;
    }

    @Override
    public int peek() {
        return list.get(list.size() - 1);
    }
}
