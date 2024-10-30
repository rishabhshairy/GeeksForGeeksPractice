package com.leetCode.arrays;

import java.util.HashSet;
import java.util.Map;

public class LongestSquareStreakInArray {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 16, 8, 2};
        System.out.println(longestSquareStreak(arr));
    }

    /**
     * Approach:
     * <p>
     * Store all elements in set to remove dups
     * then check if current number square is in set or not
     * if it exists increase count and update maxLen
     *
     * @param nums
     * @return
     */
    public static int longestSquareStreak(int[] nums) {
        HashSet<Long> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add((long) nums[i]);
        }

        int maxLen = -1;

        for (int i = 0; i < nums.length; i++) {
            int len = 1;
            while (numSet.contains((long) nums[i] * nums[i])) {
                nums[i] *= nums[i];
                len++;
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
