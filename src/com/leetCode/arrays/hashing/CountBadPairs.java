package com.leetCode.arrays.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 2364
 */
public class CountBadPairs {

    /**
     * Total pairs --> n*(n-1)/2
     * Bad pairs = total - gooa
     * goodPairs => nums[i]-i count > 1
     *
     * @param nums
     * @return
     */
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        long goodPair = 0;
        for (int i = 0; i < n; i++) {
            int key = nums[i] - 1;
            goodPair += freqMap.getOrDefault(key, 0);
            freqMap.put(key, freqMap.getOrDefault(key, 0) + 1);
        }
        return (long) n * (n-1)/2 - goodPair;
    }

    /**
     * Brute Force
     *
     * @param nums
     * @return
     */
    public long countBadPairsBrute(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i < j && (j - i != nums[j] - nums[i])) {
                    count++;
                }
            }
        }
        return count;
    }
}
