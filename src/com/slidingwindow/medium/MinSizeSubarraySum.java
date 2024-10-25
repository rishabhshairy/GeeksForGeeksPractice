package com.slidingwindow.medium;

/**
 * LC 209
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray
 * whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 */
public class MinSizeSubarraySum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        new MinSizeSubarraySum().minSubArrayLen(7, arr);
    }

    /**
     * Directly using 2 pointer and sliding window
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = 0, minLength = Integer.MAX_VALUE;

        while (right < nums.length) {
            sum += nums[right];

            // reduce window this sum breaches target
            while (sum >= target) {
                int window = right - left + 1;
                minLength = Math.min(minLength, window);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        System.out.print(minLength);
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
