package com.slidingwindow.VariableSize;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LargestSubarrayWithSumKNeg {
    public static void main(String[] args) {
        int[] negNum = {100000, -999812, -218};
        System.out.println(getLongestSubarray(negNum, 0));
    }

    public static int getLongestSubarray(int[] nums, int k) {
        // Write your code here.
        HashMap<Integer, Integer> sumMap = new LinkedHashMap<>();
        int prefixSum = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (prefixSum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // now to check for remaining window
            int reminderSum = prefixSum - k;
            if (sumMap.containsKey(reminderSum)) {
                int window = i - sumMap.get(reminderSum);
                maxLen = Math.max(maxLen, window);
            }

            if (!sumMap.containsKey(prefixSum)) {
                sumMap.put(prefixSum, i);
            }
        }

        return maxLen;
    }
}
