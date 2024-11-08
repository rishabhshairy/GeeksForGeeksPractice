package com.leetCode.DP;

import java.util.Arrays;

/**
 * LC 1671
 * You may recall that an array arr is a mountain array if and only if:
 * <p>
 * arr.length >= 3
 * There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * Given an integer array nums[], return the minimum number of elements to remove to make nums[], a mountain array.
 */
public class MinNumberOfRemovalsToMakeMountain {
    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 5, 6, 2, 3, 1};
        new MinNumberOfRemovalsToMakeMountain().minimumMountainRemovals(nums);
    }

    /**
     * Approach
     * <p>
     * We need to find the longest increasing subsequence and longest decreasing subsequence for each index
     * <p>
     * res = LIS[i] + LDS[i] - 1
     *
     * @param nums
     * @return
     */
    public int minimumMountainRemovals(int[] nums) {

        int[] lis = findLIS(nums);
        int[] lds = findLDS(nums);

        // now calculate final result
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (lis[i] > 1 && lds[i] > 1) {
                res = Math.max(res, lis[i] + lds[i] - 1);
            }

        }
        return nums.length - res;
    }

    private int[] findLDS(int[] nums) {
        int n = nums.length;
        int[] curr = new int[n];
        Arrays.fill(curr, 1);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    curr[i] = Math.max(curr[i], curr[j] + 1);
                }
            }
        }
        return curr;
    }

    private int[] findLIS(int[] nums) {
        // We will use tabulation to find LIS
        int n = nums.length;
        int[] curr = new int[n];
        Arrays.fill(curr, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    curr[i] = Math.max(curr[i], curr[j] + 1);
                }
            }
        }
        return curr;
    }
}
