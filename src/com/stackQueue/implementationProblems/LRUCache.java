package com.stackQueue.implementationProblems;

import java.util.*;

public class LRUCache {
    Map<Integer, Integer> cache;
    Queue<Integer> cacheKey;
    int maxSize;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        cacheKey = new LinkedList<>();
        maxSize = capacity;
    }

    /**
     * when get
     * first remove
     * and append at top
     * @param key
     * @return
     */
    public int get(int key) {
        if (cache.containsKey(key)) {
            cacheKey.remove(key);
            cacheKey.offer(key);
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        /**
         * As per LRU principal, if key is present
         * - Search
         * - Delete
         * - Insert
         */
        if (cache.containsKey(key)) {
            cacheKey.remove(key);
            cacheKey.offer(key);
            cache.put(key, value);
        } else {
            if (cacheKey.size() < maxSize) {
                cacheKey.offer(key);
            } else {
                cache.remove(cacheKey.poll());
                cacheKey.offer(key);
            }
            cache.put(key, value);
        }
    }
}
