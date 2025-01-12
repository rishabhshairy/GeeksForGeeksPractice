package com.stackQueue.implementationProblems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.Map;

// TODO: Learn and Implement
public class LFUCache {

    Map<Integer, Integer> cacheMap;
    Map<Integer, Integer> cacheKeyCountMap;
    Deque<Integer> cacheKey;
    int maxSize = 0;

    public LFUCache(int capacity) {
        cacheMap = new LinkedHashMap<>();
        cacheKeyCountMap = new LinkedHashMap<>();
        cacheKey = new ArrayDeque<>();
        maxSize = capacity;
    }

    public int get(int key) {
        return 0;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            cacheKey.remove(key);
            cacheKey.offer(key);
            cacheKeyCountMap.put(key, cacheKeyCountMap.get(key) + 1);
            cacheMap.put(key, value);
        } else {
            if (cacheKey.size() < maxSize) {
                cacheKey.offer(key);
                cacheKeyCountMap.put(key, cacheKeyCountMap.getOrDefault(key, 0) + 1);
            } else {

            }

//
        }
    }
}
