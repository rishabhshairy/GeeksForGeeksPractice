package com.leetcode;

import java.util.stream.IntStream;

// passing 139/142 TC's
public class PartitionToKSubsets {
    public static void main(String[] args) {
        int[] test = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        System.out.println(canPartitionKSubsets(test, k));
    }

    static boolean canPartitionKSubsets(int[] nums, int k) {
        int N = nums.length;
        int sumArr = IntStream.of(nums).sum();

        if (k==1){
            return true;
        }

        if (sumArr % k != 0) {
            return false;
        }

        int sum = sumArr / k;
        int[][] tdp = new int[N + 1][sum + 1];
        boolean[] isUsed=new boolean[N];

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    tdp[i][j] = 0;
                }
                if (j == 0) {
                    tdp[i][j] = 1;
                }

                if (i > 0 && j > 0) {

                    if (nums[i - 1] <= j) {
                        tdp[i][j] = tdp[i - 1][j] + tdp[i - 1][j - nums[i - 1]];
                    } else {
                        tdp[i][j] = tdp[i - 1][j];
                    }
                }
            }
        }
       // System.out.println(tdp[N][sum]);
        return tdp[N][sum] >= k;
    }
}
