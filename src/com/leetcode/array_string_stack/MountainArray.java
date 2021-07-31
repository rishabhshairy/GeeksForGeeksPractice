package com.leetcode.array_string_stack;

public class MountainArray {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println(validMountainArray(arr));

    }

    static boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int maxIndex = 0;
        boolean isIncreasing = false;
        boolean isdecreasing = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                isIncreasing = true;
                continue;
            } else if (arr[i] == arr[i + 1]) {
                return false;
            } else {
                maxIndex = i;
                break;
            }
        }
        for (int i = maxIndex; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isdecreasing = true;
                continue;
            } else if (arr[i] == arr[i + 1]) {
                return false;
            } else {
                isdecreasing = false;
                break;
            }
        }
        return isIncreasing && isdecreasing;
    }
}
