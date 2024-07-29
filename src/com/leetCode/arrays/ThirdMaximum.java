package com.leetCode.arrays;

import java.util.Set;
import java.util.TreeSet;

public class ThirdMaximum {
    public static void main(String[] args) {

    }

    static int thirdMax(int[] nums) {
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        Set<Integer> numSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }
        Object[] resultArr = numSet.toArray();
        if (resultArr.length == 2) {
            return Math.max((int) resultArr[0], (int) resultArr[1]);
        } else if (resultArr.length == 1) {
            return (int) resultArr[0];
        }
        return (int) resultArr[resultArr.length - 3];
    }
}
