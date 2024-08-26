package com.leetCode.arrays;

public class KthMissingPositive {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        KthMissingPositive missingPositive = new KthMissingPositive();
        missingPositive.findKthPositive(arr, 2);
    }

    public int findKthPositive(int[] arr, int k) {
        for (int num :
                arr) {
            if (num <= k) {
                k++;
            } else {
                break;
            }
        }
        return k;
    }

    public int findKthPositiveBinarySearch(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // vvimp calculation
            // generic --> arr[idx] - (idx+1)
            int missing = arr[mid] - (mid + 1);

            // eliminate left half if missing is less than K
            // it means no of missing numbers should be ahead of current index
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // return low+k;
        return (high + 1 + k);
    }
}
