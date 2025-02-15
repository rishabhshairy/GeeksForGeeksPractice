package com.leetCode.arrays;

/**
 * LC 3151
 */
public class SpecialArray1 {
    public boolean isArraySpecial(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (!special(nums[i], nums[i + 1])) {
                return false;
            }
        }
        return true;
    }

    private boolean special(int a, int b) {
        if (isEven(a) && isOdd(b)) {
            return true;
        } else if (isEven(b) && isOdd(a)) {
            return true;
        }
        return false;
    }

    private boolean isOdd(int b) {
        return b % 2 != 0;
    }

    private boolean isEven(int a) {
        return a % 2 == 0;
    }
}
