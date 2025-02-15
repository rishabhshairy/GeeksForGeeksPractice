package com.leetCode.arrays;

public class LC3105 {
    public int longestMonotonicSubarray(int[] nums) {
        int maxInc = Integer.MIN_VALUE;
        int maxDec = Integer.MIN_VALUE;

        int left = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                left++;
                maxInc = Math.max(maxInc, left);
            } else {
                left = 0;
            }
        }
        maxInc = Math.max(maxInc, left);
        left = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                left++;
                maxDec = Math.max(maxDec, left);
            } else {
                left=0;
            }
        }
        maxDec = Math.max(maxDec, left);
        return Math.max(maxInc, maxDec);
    }
}
