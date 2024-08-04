package com.dynamicProgramming.Subsequences;

/**
 * https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference
 */
public class DP16WithNegativeIntegers {

    int ans = Integer.MAX_VALUE;

    public int minimumDifference(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        call(nums, 0, 0, sum, 0);
        return ans;
    }

    public void call(int[] nums, int sum, int i, int totalSum, int count) {
        int n = nums.length / 2;

        if (count == n) {
            int x = Math.abs(totalSum - (2 * sum));
            ans = Math.min(ans, x);
            return;
        }
        if (i >= nums.length) {
            return;
        }

        call(nums, sum + nums[i], i + 1, totalSum, count + 1);
        call(nums, sum, i + 1, totalSum, count);

    }

}
