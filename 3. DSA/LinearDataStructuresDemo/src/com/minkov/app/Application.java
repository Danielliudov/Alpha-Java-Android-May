package com.minkov.app;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // when need to add at the head
        LinkedList<Integer> linkedList = new LinkedList<>();
        // in other cases
        ArrayList<Integer> arrayList = new ArrayList<>();

        Queue<Integer> linkedQueue = new LinkedList<>();
        Queue<Integer> arrayQueue = new ArrayDeque<>();

        Deque<Integer> linkedDeque = new LinkedList<>();
        Deque<Integer> arrayDeque = new ArrayDeque<>();

        // Always
        Stack<Integer> arrayStack = new Stack<>();
    }
}
