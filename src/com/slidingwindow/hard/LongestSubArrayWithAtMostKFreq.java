package com.slidingwindow.hard;

import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubArrayWithAtMostKFreq {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2, 3, 1, 2};
        System.out.println(maxSubarrayLength(arr, 2));
    }

    public static int maxSubarrayLength(int[] nums, int k) {
        int left = 0, right = 0, maxi = 0;
        Map<Integer, Integer> numsMap = new LinkedHashMap<>();

        while (right < nums.length) {
            numsMap.put(nums[right], numsMap.getOrDefault(nums[right], 0) + 1);
            while (numsMap.get(nums[right]) > k) {
                numsMap.put(nums[left], numsMap.get(nums[left]) - 1);
                left++;
            }
            maxi = Math.max(maxi, right - left + 1);
            right++;
        }
        return maxi;
    }
}
