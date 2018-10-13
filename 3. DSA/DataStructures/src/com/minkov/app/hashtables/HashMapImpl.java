package com.minkov.app.hashtables;

import com.minkov.app.base.MapBase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashMapImpl<K, V> implements MapBase<K, V> {
    private static final int INITIAL_CAPACITY = 8;
    private static final double LOAD_FACTOR = 0.75;
    private int size;
    private int capacity;
    private List<List<Pair>> buckets;

    public HashMapImpl() {
        this.size = 0;
        this.capacity = INITIAL_CAPACITY;
        this.buckets = new ArrayList<>();
        prepareBucketsSize(buckets, capacity);
    }

    @Override
    public void put(K key, V value) {
        Pair pair = new Pair(key, value);
        if (containsKey(key)) {
            List<Pair> bucket = getOrCreateBucket(key);
            int index = bucket.indexOf(pair);
            bucket.set(index, pair);
        } else {
            if (shouldResize()) {
                resize();
            }

            List<Pair> bucket = getOrCreateBucket(key);
            bucket.add(pair);
            ++size;
        }
    }


    @Override
    public V get(K key) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Key not in map");
        }

        for (Pair pair : buckets.get(getIndex(key))) {
            if (pair.key.equals(key)) {
                return pair.value;
            }
        }

        // Should never come here
        return null;
    }

    @Override
    public boolean containsValue(V value) {
        for (List<Pair> bucket : buckets) {
            if (bucket == null) {
                continue;
            }

            for (Pair pair : bucket) {
                if (pair.value != value) {
                    continue;
                }
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsKey(K key) {
        List<Pair> bucket = getOrCreateBucket(key);
        Pair pairForCheck = new Pair(key, null);
        return bucket.indexOf(pairForCheck) >= 0;
    }

    @Override
    public void remove(K key) {
        if (!containsKey(key)) {
            return;
        }

        List<Pair> bucket = getOrCreateBucket(key);
        Pair pairForCheck = new Pair(key, null);
        --size;
        bucket.remove(pairForCheck);
    }

    @Override
    public int size() {
        return size;
    }

    private List<Pair> getOrCreateBucket(K key) {
        int index = getIndex(key);
        if (buckets.get(index) == null) {
            buckets.set(index, new LinkedList<>());
        }

        return buckets.get(index);
    }

    private int getIndex(K key) {
        int hashCode = Math.abs(key.hashCode());
        return hashCode % capacity;
    }

    private void resize() {
        List<List<Pair>> oldBuckets = buckets;
        buckets = new ArrayList<>();
        capacity *= 2;
        size = 0;
        for (int i = 0; i < capacity; i++) {
            buckets.add(null);
        }

        for (List<Pair> bucket : oldBuckets) {
            for (Pair pair : bucket) {
                put(pair.key, pair.value);
            }
        }
    }

    private boolean shouldResize() {
        return LOAD_FACTOR * capacity <= size;
    }

    private void prepareBucketsSize(List<List<Pair>> buckets, int size) {
        for (int i = 0; i < size; i++) {
            buckets.add(null);
        }
    }

    private class Pair {
        K key;
        V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj.getClass() != Pair.class) {
                return false;
            }

            Pair other = (Pair) obj;
            return other.key == key;
        }
    }
}
