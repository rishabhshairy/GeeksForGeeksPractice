package com.geeksForGeeks.arrays;

public class MaxOnesInBinaryArray {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 0, 1, 1, 1};
        System.out.println(maxOnes(arr));
    }

    public static int maxOnes(int[] arr) {
        int maxCount = Integer.MIN_VALUE;
        int currCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                currCount++;
            } else if (arr[i] == 0) {
                maxCount = Math.max(maxCount, currCount);
                currCount = 0;
            }
        }
        if (currCount > maxCount) {
            maxCount = currCount;
        }
        return maxCount;
    }
}
