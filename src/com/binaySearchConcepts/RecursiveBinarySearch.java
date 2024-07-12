package com.binaySearchConcepts;

public class RecursiveBinarySearch {
    public static void main(String[] args) {
        System.out.print(findTargetIndex(new int[]{3, 6, 7, 11, 19, 20, 33, 44}, 32));
    }

    public static int findTargetIndex(int[] arr, int target) {
        return solve(arr, 0, arr.length - 1, target);
    }

    private static int solve(int[] arr, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (target > arr[mid]) {
            return solve(arr, mid + 1, high, target);
        } else {
            return solve(arr, low, mid - 1, target);
        }
    }
}
