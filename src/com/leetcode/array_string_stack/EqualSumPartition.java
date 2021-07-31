package com.leetcode.array_string_stack;

import java.util.Scanner;
import java.util.stream.IntStream;

public class EqualSumPartition {
    public static void main(String[] args) {
        int[] test = {1, 2, 5};
        System.out.println(canPartition(test));
    }

    static boolean canPartition(int[] arr) {
        int N = arr.length;
        int sum = IntStream.of(arr).sum();

        if (sum % 2 != 0) {
            return false;
        }
        sum=sum/2;
        Boolean tdp[][] = new Boolean[N + 1][sum + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= sum; j++) {
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
