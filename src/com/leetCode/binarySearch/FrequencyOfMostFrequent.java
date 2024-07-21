package com.leetCode.binarySearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FrequencyOfMostFrequent {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4};
//        int[] nums = {1, 4, 8, 13};
//        int[] nums = {3, 9, 6};
        int k = 5;
        maxFrequency(nums, k);
    }

    /**
     * This is Sliding window approach
     *
     * @param nums
     * @param k
     * @return
     */
    private static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int prefixSum = 0;
        long target = 0;
        for (int right = 0; right < nums.length; right++) {
            target = nums[right];
            prefixSum += target;
            System.out.println(prefixSum);
            if (((long)(right - left + 1) * target - prefixSum) > k) {
                System.out.println("right = " + right);
                prefixSum -= nums[left];
                left++;
            }
        }
        return nums.length - left;
    }

    public static int maxFrequencyBruteForce(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int j = i - 1;
            int steps = k;

            while (j >= 0 && (nums[i] - nums[j]) <= steps) {
                steps -= (nums[i] - nums[j]);
                j--;
            }
            ans = Math.max(ans, i - j);
        }
//        System.out.println(ans);
        return ans;
    }
}
