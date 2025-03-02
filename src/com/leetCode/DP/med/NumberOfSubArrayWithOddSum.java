package com.leetCode.DP.med;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfSubArrayWithOddSum {

    /**
     * Hashmap and prefix sum approach
     *
     * @param arr
     * @return
     */
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int prefixSum = 0;
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            int mod = prefixSum % 2;
            if (mod == 1) {
                // count even prefix sum
                count += map.getOrDefault(0, 0);
            } else if (mod == 0) {
                count += map.getOrDefault(1, 0);
            }
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return count;
    }

    public int numOfSubarraysBrute(int[] arr) {
        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum % 2 != 0) {
                    sums.add(sum);
                }
            }
        }
        return sums.size();
    }
}
