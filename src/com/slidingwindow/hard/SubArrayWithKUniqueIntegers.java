package com.slidingwindow.hard;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LC 992
 * Given an integer array nums and an integer k, return the number of good subarrays of nums.
 * <p>
 * A good array is an array where the number of different integers in that array is exactly k.
 */
public class SubArrayWithKUniqueIntegers {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums, k) - subarraysWithKDistinct(nums, k - 1));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer, Integer> numsMap = new LinkedHashMap<>();

        int left = 0, right = 0, count = 0;

        while (right < nums.length) {
            numsMap.put(nums[right], numsMap.getOrDefault(nums[right], 0) + 1);
            while (numsMap.size() > k) {
                numsMap.put(nums[left], numsMap.get(nums[left]) - 1);
                if (numsMap.get(nums[left]) == 0) {
                    numsMap.remove(nums[left]);
                }
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
}
