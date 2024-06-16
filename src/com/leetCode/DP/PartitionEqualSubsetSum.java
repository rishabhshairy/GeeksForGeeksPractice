package com.leetCode.DP;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] arr = {1, 5, 5, 11};
        System.out.println(canPartition(arr));
    }

    public static boolean canPartition(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if (sum % 2 != 0) {
            return false;
        }
        int N = arr.length;
        boolean[][] tdp = new boolean[N + 1][sum + 1];

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    tdp[i][j] = false;
                }
                if (j == 0) {
                    tdp[i][j] = true;
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    tdp[i][j] = tdp[i - 1][j - arr[i - 1]] || tdp[i - 1][j];
                } else {
                    tdp[i][j] = tdp[i - 1][j];
                }
            }
        }
        return tdp[N][sum];
    }
}
