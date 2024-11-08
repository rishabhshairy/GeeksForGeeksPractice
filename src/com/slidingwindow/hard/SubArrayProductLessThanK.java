package com.slidingwindow.hard;

public class SubArrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        int count = 0;
        int prod = 1, left = 0, right = 0;

        while (right < nums.length) {
            prod = prod * nums[right];
            while (prod >= k) {
                prod = prod / nums[left];
                left++;
            }
            count += (right - left + 1);
            right++;
        }
        return count;
    }
}
