package com.slidingwindow.medium;

/**
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 * https://leetcode.com/problems/max-consecutive-ones-iii/description/
 */
public class MaxConsecutiveOnes3 {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 0;
        System.out.println(longestOnesBruteForce(arr, k));
    }

    /**
     * Better solution
     * two while loops
     * 2 pointer and sliding window
     *
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, maxLen = 0;
        int zeros = 0, len = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                zeros++;
            }
            if (zeros <= k) {
                len = right - left + 1;
                maxLen = Math.max(len, maxLen);
            }

            if (zeros > k) {
                while (zeros > k) {
                    if (nums[left++] == 0) {
                        zeros--;
                    }
                }
            }


            right++;

        }
        return maxLen;
    }

    /**
     * Approaching this problem as subarray with at max K zeros
     *
     * @param nums
     * @param k
     * @return
     */
    public static int longestOnesBruteForce(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int maxLen = Integer.MIN_VALUE;
        int len = 0;

        for (int i = 0; i < nums.length; i++) {
            int zeros = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    zeros++;
                }
                if (zeros > k) {
                    break;
                } else {
                    len = j - i + 1;
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen;
    }
}
