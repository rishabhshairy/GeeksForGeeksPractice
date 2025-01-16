package com.leetCode.arrays.binarySearch;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class FindRightInterval {
    public static void main(String[] args) {
        int[][] intervals = {{3, 4}, {2, 3}, {1, 2}};
        FindRightInterval obj = new FindRightInterval();
        obj.findRightInterval(intervals);
    }

    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        Map<Integer, Integer> indexMap = new TreeMap<>();
        int[] start = new int[n];

        for (int i = 0; i < n; i++) {
            int starti = intervals[i][0];
            start[i] = starti;
            indexMap.put(starti, i);
        }

        Arrays.sort(start);

        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            int rightInterval = solve(end, n, start);
            result[i] = indexMap.getOrDefault(rightInterval, -1);
        }

        return result;
    }

    private int solve(int end, int n, int[] start) {
        int left = 0;
        int right = n - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (start[mid] >= end) {
                ans = start[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return ans;
    }
}
