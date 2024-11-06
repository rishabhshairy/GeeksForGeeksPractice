package com.leetCode.arrays;

import java.util.*;

public class CanArrayBeSorted {
    public static void main(String[] args) {
        int[] nums = {8, 4, 2, 30, 15,7};
        CanArrayBeSorted obj = new CanArrayBeSorted();
        obj.canSortArray(nums);
    }

    public boolean canSortArray(int[] nums) {
        int currMax = nums[0];
        int lastMax = 0;
        int currSetBits = countSetBits(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            boolean bitChange = currSetBits != countSetBits(nums[i]);

            if (bitChange) {
                System.out.println(nums[i]);
                lastMax = currMax;
            }

            if (nums[i] > currMax) {
                currMax = nums[i];
                currSetBits = countSetBits(currMax);
            }
            if (nums[i] < lastMax) {
                return false;
            }
            System.out.println(lastMax);
            System.out.println(currMax);
        }
        return true;
    }

    private int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            count += (num & 1);
            num >>= 1;
        }
        return count;
    }
}
