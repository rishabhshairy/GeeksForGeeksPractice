package com.geeksForGeeks.arrays.level2;

import java.util.List;

public class FindKthRotation {
    public static void main(String[] args) {
        List<Integer> arr = List.of(5, 1, 2, 3, 4);
        System.out.println(findKRotation(arr));
    }

    public static int findKRotation(List<Integer> arr) {
        // Code here
        // This does not handle the duplicate cases
        // Approach is to find index of minimum element which will indicate no of rotations
        int index = -1; // assuming array is fully rotated
        int low = 0;
        int high = arr.size() - 1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;

            // if search space is already sorted , low will be always the min element
            if (arr.get(low) <= arr.get(high)) {
                if (arr.get(low) < ans) {
                    index = low;
                    ans = arr.get(low);
                }
                break;
            }

            // now check for left and right sorted
            if (arr.get(low) <= arr.get(mid)) {
                if (arr.get(low) < ans) {
                    index = low;
                    ans = arr.get(low);
                }
                // Truncate left half
                low = mid + 1;
            } else {
                // keep minimum
                if (arr.get(mid) < ans) {
                    index = mid;
                    ans = arr.get(mid);
                }
                // Truncate left half
                high = mid - 1;
            }
        }
        return index;
    }
}
