package com.leetCode.arrays.hashing;

import java.util.Map;
import java.util.TreeMap;

public class Merge2DArray {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] row : nums1) {
            map.put(row[0], row[1]);
        }
        System.out.println(map);
        for (int[] row : nums2) {
            if (map.containsKey(row[0])) {
                map.put(row[0], map.get(row[0]) + row[1]);
            } else {
                map.put(row[0], row[1]);
            }
        }

        int[][] result = new int[map.size()][2];
        int index = 0;
        for (int key : map.keySet()) {
            result[index][0] = key;
            result[index][1] = map.get(key);
        }
        return result;
    }
}
