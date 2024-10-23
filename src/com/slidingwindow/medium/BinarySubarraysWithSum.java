package com.slidingwindow.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * LC 930
 * Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
 */
public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0, 0};
        int goal = 0;
//        System.out.println(numSubarraysWithSumBetter(nums, goal));
        System.out.println(numSubarraysWithSum(nums, goal));
    }

    /**
     * This is the best solution
     * VVIMP concept here
     * f(num,goal) - f(num, goal-1)
     *
     * @param nums
     * @param goal
     * @return
     */
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarraysWithSumHelper(nums, goal) - numSubarraysWithSumHelper(nums, goal - 1);
    }

    public static int numSubarraysWithSumHelper(int[] nums, int goal) {
        int left = 0, right = 0, sum = 0, count = 0;
        if (goal < 0) {
            return 0;
        }
        while (right < nums.length) {
            sum += nums[right];
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }
            // now count will be current window size
            count += (right - left + 1);
            right++;
        }
        return count;
    }

    /**
     * This a better solution, but not optimal
     *
     * @param nums
     * @param goal
     * @return
     */
    public static int numSubarraysWithSumBetter(int[] nums, int goal) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> sumMap = new LinkedHashMap<>();
        sumMap.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumMap.containsKey(sum - goal)) {
                count += sumMap.get(sum - goal);
            }
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
