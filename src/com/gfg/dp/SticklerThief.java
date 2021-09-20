package com.gfg.dp;

import java.util.Arrays;

public class SticklerThief {
    public static void main(String[] args) {
        int[] a = {5, 5, 10, 100, 10, 5};
        SticklerThief thief = new SticklerThief();
        System.out.println(thief.FindMaxSum(a, a.length));
    }

    public int FindMaxSum(int arr[], int n) {
        // Your code here
        if (arr.length == 0) {
            return 0;
        }
        int index = 0;
        int[] memTable = new int[10001];
        Arrays.fill(memTable, -1);
        return maximiseLoot(arr, index, memTable);

    }

    private int maximiseLoot(int[] arr, int index, int[] mem) {
        if (index >= arr.length) {
            return 0;
        }

        if (mem[index] != -1) {
            return mem[index];
        }
        int sumOne = arr[index] + maximiseLoot(arr, index + 2, mem);
        int sumTwo = maximiseLoot(arr, index + 1, mem);

        return mem[index] = Math.max(sumOne, sumTwo);
    }
}
