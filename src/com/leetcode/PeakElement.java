package com.leetcode;

public class PeakElement {
    public static void main(String[] args) {
        int[] test = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(test));

    }

    static int findPeakElement(int[] nums) {
        int peekIndex = 0;
        int n = nums.length;
        int min = Integer.MIN_VALUE;
        if (n==1){
            return 0;
        }
        if (n == 2) {
            return nums[1] > nums[0] ? 1 : 0;
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (nums[i] > min && nums[i] > nums[i + 1]) {

                    peekIndex = i;
                }
            } else if (i == n - 1) {
                if (nums[i] > nums[i - 1] && nums[i] > min) {

                    peekIndex = i;
                }
            } else if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                peekIndex = i;
            }
        }
        return peekIndex;
    }
}
