package com.slidingwindow.VariableSize;

public class LargestSubarryWithSumKPos {
    public static void main(String[] args) {
        int[] posNums = {1, 2, 3, 1, 1, 1, 1};
        System.out.println(getLongestSubarray(posNums, 3));
    }

    /**
     * Approach
     * Using sliding window
     * <p>
     * reduce the number if sum > k
     * this will only work if all numbers are positive
     *
     * @param nums
     * @param k
     * @return
     */
    public static int getLongestSubarray(int[] nums, int k) {
        // Write your code here.
        int left = 0, right = 0, sum = 0, maxLen = 0;

        while (right < nums.length) {
            sum += nums[right];
            while (left <= right && sum > k) {
                sum -= nums[left++];
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }
        return maxLen;
    }
}
