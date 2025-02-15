package com.leetCode.arrays.slidinWindow;

public class MaxSubarrayAscendingSum {
    public static void main(String[] args) {
        int[] arr = {12};
        MaxSubarrayAscendingSum obj = new MaxSubarrayAscendingSum();
        obj.maxAscendingSum(arr);
    }

    public int maxAscendingSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            while (right + 1 < nums.length && nums[right] < nums[right + 1] ) {
                right++;
            }
//            System.out.println(right);
            while (left <= right) {
                sum += nums[left];
                left++;
//                System.out.println(sum);
            }
            maxSum = Math.max(maxSum, sum);
            sum = 0;
            right++;
        }
//        System.out.println(maxSum);
        return maxSum;
    }
}
