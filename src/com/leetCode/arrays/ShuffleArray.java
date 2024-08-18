package com.leetCode.arrays;

import java.util.Scanner;

public class ShuffleArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = {2, 5, 1, 3, 4, 7};
        shuffle(a, n);
    }

    static int[] shuffle(int[] nums, int n) {
        int result[] = new int[nums.length];
        int j = n;
        int k = 0;
        for (int i = 0; i < n; i++) {
            result[k++] = nums[i];

            result[k++] = nums[j];
            j++;
        }
        return result;
    }
}
