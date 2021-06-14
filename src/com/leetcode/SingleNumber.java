package com.leetcode;

public class SingleNumber {
    public static void main(String[] args) {
        int[] num = {4, 1, 2, 1, 2};
        singleNumber(num);
    }

    static int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
            System.out.println(res);
        }
        return res;

    }
}
