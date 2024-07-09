package com.leetCode.array_string_stack;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        subarraySum(new int[]{1, 1, 1}, 2);
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> sumMap = new HashMap<>();

        // intialize map with 0 sum;
        sumMap.put(sum, 1);

        for (int num :
                nums) {
            sum += num;
            if (sumMap.containsKey(sum - k)) {
                count += sumMap.get(sum - k);
            }
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
