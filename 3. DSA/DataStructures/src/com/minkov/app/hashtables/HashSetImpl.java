package com.minkov.app.hashtables;

import com.minkov.app.base.SetBase;

import java.util.ArrayList;
import java.util.List;

public class HashSetImpl<T> implements SetBase<T> {
    private static final int INITIAL_CAPACITY = 8;
    private static final double LOAD_FACTOR = 0.75;
    private int size;
    private int capacity;
    private List<List<T>> buckets;

    public HashSetImpl() {
        this.size = 0;
        this.capacity = INITIAL_CAPACITY;
        buckets = new ArrayList<>();
        prepareBucketsSize(buckets, capacity);
    }

    @Override
    public void add(T value) {
        if (contains(value)) {
            return;
        }

        if (shouldResize()) {
            resize();
        }

        List<T> bucket = getOrCreateBucket(value);

        bucket.add(value);

        ++size;
    }

    @Override
    public boolean contains(T value) {
        List<T> bucket = getOrCreateBucket(value);

        return bucket.indexOf(value) >= 0;
    }

    @Override
    public void remove(T value) {
        if (!contains(value)) {
            return;
        }

        List<T> bucket = getOrCreateBucket(value);
        bucket.remove(value);
    }

    @Override
    public int size() {
        return size;
    }

    private List<T> getOrCreateBucket(T value) {
        int index = getIndex(value);
        if (buckets.get(index) == null) {
            buckets.set(index, new ArrayList<>());
        }

        return buckets.get(index);
    }

    private int getIndex(T value) {
        int hashCode = Math.abs(value.hashCode());

        return hashCode % capacity;
    }

    private void resize() {
        List<List<T>> oldBuckets = buckets;
        capacity *= 2;
        size = 0;

        buckets = new ArrayList<>();
        prepareBucketsSize(buckets, capacity);

        for (List<T> bucket : oldBuckets) {
            if (bucket == null) {
                continue;
            }

            for (T value : bucket) {
                add(value);
            }
        }
    }

    private boolean shouldResize() {
        return LOAD_FACTOR * capacity <= size;
    }

    private void prepareBucketsSize(List<List<T>> buckets, int size) {
        for (int i = 0; i < size; i++) {
            buckets.add(null);
        }
    }
}
