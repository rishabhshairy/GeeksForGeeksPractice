package com.leetCode.binarySearch;

import java.util.Arrays;

/**
 * LC Daily
 * LC 2563
 */
public class FairPair {
    public static void main(String[] args) {
        int[] nums = {1, 7, 9, 2, 5};
        FairPair obj = new FairPair();
        long fairPairs = obj.countFairPairs(nums, 11, 11);
        System.out.println(fairPairs);
    }

    /**
     * Binary Search Approach
     * For every nums in array
     * Find lower and upper bound range
     * those numbers can be added to that range
     *
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public long countFairPairs(int[] nums, int lower, int upper) {
        long count = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int lowerTarget = lower - nums[i];
            int highTarget = upper - nums[i];

            int lowerBound = findLowerUpper(nums, lowerTarget, i + 1, nums.length - 1, false);
            int upperBound = findLowerUpper(nums, highTarget, i + 1, nums.length - 1, true);

//            System.out.println(lowerBound);
//            System.out.println(upperBound);

            count += (upperBound - lowerBound);
        }
        return count;
    }

    private int findLowerUpper(int[] nums, int target, int left, int right, boolean findUpper) {
        int ans = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // this will find lower bound
            if (!findUpper) {

                if (nums[mid] >= target) {
                    ans = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } // this will find upper bound
            else {

                if (nums[mid] > target) {
                    ans = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }
        }
        return left;
    }

    /**
     * Brute Force
     *
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public long countFairPairsBruteForce(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > lower) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (lower <= sum && sum <= upper) {
                    count++;
                }
            }
        }
        return count;
    }
}
