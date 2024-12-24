package com.slidingwindow.medium;

import java.util.TreeMap;

public class ContinousSubarray {
    public static void main(String[] args) {
        int[] nums = {5, 4, 2, 4};
        ContinousSubarray obj = new ContinousSubarray();
        System.out.println(obj.continuousSubarrays(nums));
    }

    public long continuousSubarrays(int[] nums) {
        long ans = 0;

        int left = 0, right = 0;
        int n = nums.length;
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();

        while (right < n) {

            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

            while (freqMap.lastKey() - freqMap.firstKey() > 2) {
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                if (freqMap.get(nums[left]) == 0) {
                    freqMap.remove(nums[left]);
                }
                left++;
            }

            ans += right - left + 1;
            right++;
        }

        return ans;
    }
}
