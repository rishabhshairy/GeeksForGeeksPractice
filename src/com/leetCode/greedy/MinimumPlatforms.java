package com.leetCode.greedy;

import java.util.Arrays;

public class MinimumPlatforms {
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);

        int depIndex = 0;
        int maxPlatform = 0;

        for (int i = 1; i < arr.length; i++) {
            if (dep[depIndex] < arr[i]) {
                depIndex++;
            } else {
                maxPlatform++;
            }
        }
        return maxPlatform;
    }
}
