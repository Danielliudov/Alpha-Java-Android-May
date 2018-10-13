package com.minkov.app.base;

public interface MapBase<K, V> {
    void put(K key, V value);

    V get(K key);

    boolean containsKey(K key);

    /**
     * Checks if a values is present in the Map
     * VERY, VERY SLOW: O(N)
     *
     * @param value the value to check
     * @return whether the value is present in the MAP
     */
    boolean containsValue(V value);

    void remove(K key);

    int size();
}
