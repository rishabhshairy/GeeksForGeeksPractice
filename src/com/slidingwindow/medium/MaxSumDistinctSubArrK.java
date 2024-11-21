package com.slidingwindow.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * LC 2461 Maximum Sum of Distinct Subarrays With Length K
 * You are given an integer array nums and an integer k. Find the maximum subarray sum of all the
 * subarrays of nums that meet the following conditions:
 * <p>
 * The length of the subarray is k, and
 * All the elements of the subarray are distinct.
 * Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class MaxSumDistinctSubArrK {

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1};
        int k = 3;
        System.out.println(maximumSubarraySum(nums, k));
    }

    /**
     * Sliding window
     *
     * @param nums
     * @param k
     * @return
     */
    private static long maximumSubarraySum(int[] nums, int k) {
        int left = 0;
        int right = 0;
        long runningSum = 0;
        long maxi = 0;
        Set<Integer> numSet = new HashSet<>();

        while (right < nums.length) {

            // remove elements from set when window is hit
            int curr = nums[right];
            while (numSet.contains(curr) || (right - left + 1) > k && left < right) {
                runningSum -= nums[left];
                numSet.remove(nums[left]);
                left++;
            }

            // add elements to set
            runningSum += curr;
            numSet.add(curr);

            // when window is hit update maxi
            if (right - left + 1 == k) {
                maxi = Math.max(maxi, runningSum);
            }
            right++;
        }
        return maxi;
    }

    /**
     * Brute Force Approach
     *
     * @param nums
     * @param k
     * @return
     */
    public static long maximumSubarraySumBruteForce(int[] nums, int k) {

        Set<Integer> numSet = new HashSet<>();
        long maxi = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length - k + 1; i++) {
            System.out.println(i);
            long sum = 0;
            for (int j = i; j < i + k; j++) {
                if (numSet.contains(nums[j])) {
                    sum = 0;
                    break;
                }
                numSet.add(nums[j]);
                sum += nums[j];
            }
            System.out.println(sum);
            System.out.println(numSet);
            numSet.clear();
            maxi = Math.max(maxi, sum);
        }
        return maxi == Integer.MIN_VALUE ? 0 : maxi;
    }
}
