package com.leetCode.arrays.prefixSum;

import java.util.Map;

public class MaxAbsoluteSumSubArray {

    /**
     * Run kadane 2 times
     *
     * @param nums
     * @return
     */
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;

        int sum = 0;
        for (int num : nums) {
            sum += num;
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                sum = 0;
            }

        }
        sum = 0;
        for (int num : nums) {
            sum += num;
            minSum = Math.min(minSum, sum);
            if (sum > 0) {
                sum = 0;
            }
        }
        return Math.max(Math.abs(maxSum), Math.abs(minSum));
    }
}
