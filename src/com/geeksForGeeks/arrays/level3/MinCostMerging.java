package com.geeksForGeeks.arrays.level3;

public class MinCostMerging {
    public static void main(String[] args) {
        int[] arr = {6, 4, 4, 6};
        System.out.println(findMin(arr));
    }

    public static int findMin(int[] arr) {
        int n = arr.length;
        int[][] tdp = new int[n + 1][n + 1];

        if (arr.length == 0) {
            return 0;
        }

        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <=n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }
        int len, i, j, k;

        for (len = 2; len <= n; len++) {
            for (i = 1; i <= n - len + 1; i++) {
                j = i + len - 1;

                int sum = prefixSum[j] - prefixSum[i - 1];
                tdp[i][j] = Integer.MAX_VALUE;

                for (k = i; k < j; k++) {
                    tdp[i][j] = Math.min(tdp[i][j], tdp[i][k] + sum + tdp[k + 1][j]);
                }
            }
        }
        return tdp[1][n];
    }
}
