package com.leetCode.arrays.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class DesignNumberContainer {
    Map<Integer, SortedSet<Integer>> map;
    Map<Integer, Integer> indexNumberMap;

    public DesignNumberContainer() {
        map = new HashMap<>();
        indexNumberMap = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexNumberMap.containsKey(index)) {
            int prev = indexNumberMap.get(index);
            map.get(prev).remove(index);
            if (map.get(prev).isEmpty()) {
                map.remove(prev);
            }
        }
        indexNumberMap.put(index, number);
        map.putIfAbsent(number, new TreeSet<>());
        map.get(number).add(index);
    }

    public int find(int number) {
        if (!map.containsKey(number)) {
            return -1;
        }
        System.out.println(map.get(number));
        return map.get(number).first();
    }
}
