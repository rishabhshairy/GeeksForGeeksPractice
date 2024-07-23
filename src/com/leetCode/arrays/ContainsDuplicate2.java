package com.leetCode.arrays;

import java.util.HashMap;

public class ContainsDuplicate2 {
    public static void main(String[] args) {
        int[] test = {1, 2, 3, 1, 2, 3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(test, k));
    }

    static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hmap.containsKey(nums[i]) && (i - hmap.get(nums[i])) <= k) {
                return true;
            }
            hmap.put(nums[i], i);

        }
        return false;
    }
}
