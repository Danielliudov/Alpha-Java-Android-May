package com.minkov.app.trees;

import com.minkov.app.base.BinaryHeapBase;

import java.util.ArrayList;
import java.util.Collections;

// MinHeap, best is the smallest
public class BinaryHeap<T extends Comparable<T>> implements BinaryHeapBase<T> {

    private final ArrayList<T> values;

    public BinaryHeap() {
        this.values = new ArrayList<>();
    }

    @Override
    public void push(T value) {
        values.add(value);
        heapifyUp();
    }

    @Override
    public T deleteBest() {
        T valueToReturn = getBest();
        values.set(0, values.get(values.size() - 1));
        values.remove(values.size() - 1);
        heapifyDown();
        return valueToReturn;
    }

    @Override
    public T getBest() {
        return values.get(0);
    }

    @Override
    public int size() {
        return values.size();
    }

    private void heapifyUp() {
        int index = values.size() - 1;
        while (index > 0) {
            T value = values.get(index);

            int parentIndex = (index - 1) / 2;
            T parentValue = values.get(parentIndex);

            // value is not better than parent
            if (value.compareTo(parentValue) >= 0) {
                break;
            }

            Collections.swap(values, index, parentIndex);
            index = parentIndex;
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (index < values.size()) {
            T bestValue = values.get(index);
            int bestIndex = index;

            int leftIndex = 2 * index + 1;
            if (leftIndex >= values.size()) {
                break;
            }

            T leftValue = values.get(leftIndex);

            // leftValue is better
            if (leftValue.compareTo(bestValue) < 0) {
                bestIndex = leftIndex;
                bestValue = leftValue;
            }


            int rightIndex = 2 * index + 2;
            if (rightIndex >= values.size()) {
                break;
            }

            T rightValue = values.get(rightIndex);

            // rightValue is better
            if (rightValue.compareTo(bestValue) < 0) {
                bestIndex = rightIndex;
                bestValue = rightValue;
            }

            if (index == bestIndex) {
                break;
            }

            Collections.swap(values, index, bestIndex);
            index = bestIndex;
        }
    }
}
