package com.leetCode.array_string_stack;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        System.out.println(maxSubArrayBruteForce(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArrayBetterApproach(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public static int maxSubArrayBruteForce(int[] nums) {
        // TC --> O(n^2)
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k < j; k++) {
                    sum += nums[k];
                }
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    /**
     * TC --> O(n^2)
     *
     * @param nums
     * @return
     */
    public static int maxSubArrayBetterApproach(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    /**
     * TC --> O(N) --> Here we will not consider sum < 0
     *
     * @param nums
     * @return
     */
    public static long maxSubArray(int[] nums) {
        long maxSum = Integer.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(sum, maxSum); // keep checking maximum sum till subArray point
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}
