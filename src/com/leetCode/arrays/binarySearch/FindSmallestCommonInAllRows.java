package com.leetCode.arrays.binarySearch;

import java.util.HashMap;
import java.util.Map;

public class FindSmallestCommonInAllRows {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4, 5}, {2, 4, 5, 8, 10}, {3, 5, 7, 9, 11}, {1, 3, 5, 7, 9}};
        int mini = Integer.MAX_VALUE;
        Map<Integer, Integer> common = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                common.put(arr[i][j], common.getOrDefault(common.get(arr[i][j]), 0) + 1);
                if (common.containsKey(arr[i][j]) && common.get(arr[i][j]) == arr.length) {
                    mini = arr[i][j];
                }
            }
        }
        System.out.println(common);
        System.out.println(mini);

    }
}
