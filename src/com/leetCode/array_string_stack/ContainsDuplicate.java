package com.leetCode.array_string_stack;

import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] test = {1, 2, 3, 1};
    }

    static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hs.contains(nums[i])){
                return false;
            }
            hs.add(nums[i]);
        }
        return true;
    }
}
