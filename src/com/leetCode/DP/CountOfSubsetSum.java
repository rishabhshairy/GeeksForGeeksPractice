package com.leetCode.DP;

public class CountOfSubsetSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3};
        int x = 6;
        System.out.println(countSubsets(arr, x));
    }

    private static int countSubsets(int[] arr, int sum) {
        int n = arr.length;
        int[][] tdp = new int[n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++) {
            tdp[0][i] = 0;
        }

        for (int i = 0; i < n + 1; i++) {
            tdp[i][0] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    tdp[i][j] = Math.max(1 + tdp[i - 1][j - arr[i - 1]], tdp[i - 1][j - 1]);
                } else {
                    tdp[i][j] = tdp[i - 1][j - 1];
                }
            }
        }
        return tdp[n][sum];
    }
}
