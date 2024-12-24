package com.leetCode.binarySearch;

import java.util.Arrays;
import java.util.Comparator;

/**
 * LC 2070\
 * https://leetcode.com/problems/most-beautiful-item-for-each-query/description/?envType=daily-question&envId=2024-11-12
 */
public class MostBeautifulForEach {
    public static void main(String[] args) {
        int[][] items = {{1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}};
        int[] queries = {1, 2, 3, 4, 5, 6};
        MostBeautifulForEach obj = new MostBeautifulForEach();
        obj.maximumBeauty(items, queries);
    }

    /**
     * Binary Search optimization
     *
     * @param items
     * @param queries
     * @return
     */
    private int[] maximumBeauty(int[][] items, int[] queries) {
        int[] result = new int[queries.length];
        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        // pre-process the beauty array to store max beauty till certain price
        for (int i = 1; i < items.length; i++) {
            items[i][1] = Math.max(items[i][1], items[i - 1][1]);
        }

        for (int currPrice = 0; currPrice < queries.length; currPrice++) {
            findMaxBeauty(items, queries[currPrice], currPrice, result);
        }
        return result;
    }

    private void findMaxBeauty(int[][] items, int query, int index, int[] result) {
        int left = 0;
        int right = items.length - 1;
        int currMax = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int currPrice = items[mid][0];
            if (currPrice <= query) {
                left = mid + 1;
                currMax = Math.max(currMax, items[mid][1]);
            } else {
                right = mid - 1;
            }
        }
        result[index] = currMax;
//        System.out.println(result[index]);
    }

    /**
     * Trying out brute force
     *
     * @param items
     * @param queries
     * @return
     */
    public int[] maximumBeautyBruteForce(int[][] items, int[] queries) {
        int n = queries.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int currMax = Integer.MIN_VALUE;
            for (int currItem = 0; currItem < items.length; currItem++) {
                if (items[currItem][0] <= queries[i]) {
                    currMax = Math.max(currMax, items[currItem][1]);
                }
            }
            result[i] = currMax;
            System.out.println(result[i]);
        }
        return result;
    }
}
