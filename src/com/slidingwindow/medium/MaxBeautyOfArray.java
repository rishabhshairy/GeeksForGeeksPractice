package com.slidingwindow.medium;

import java.util.Arrays;
import java.util.Map;

public class MaxBeautyOfArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1};
        MaxBeautyOfArray obj = new MaxBeautyOfArray();
        System.out.println(obj.maximumBeauty(nums, 10));
    }

    /**
     * Approach
     * Sort Array
     * Problem drill down to find max subarray where arr[j]-arr[i] <= 2*k
     *
     * @param nums
     * @param k
     * @return
     */
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 0;
        int maxLen = 0;

        while (right < nums.length) {
            int currDiff = nums[right] - nums[left];

            while (currDiff > 2 * k) {
                left++;
                currDiff = nums[right] - nums[left];
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
