package com.leetCode.arrays.prefixSum;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class MinimizeMaxOfArray {
    // TODO:: Amazon question
    public static void main(String[] args) {
        int[] nums = {3, 7, 1, 6};
    }

    /**
     * Brute force approach
     * @param nums
     * @return
     */
    public int minimizeArrayValue(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        return 0;
    }
}
