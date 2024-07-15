package com.geeksForGeeks.arrays.level2;

import java.util.Arrays;
import java.util.List;

public class FindKthRotationInRotatedSortedWithDuplicates {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 1, 1);
        System.out.print(findKRotation(arr));
    }

    public static int findKRotation(List<Integer> arr) {
        // Code here
        int[] nums = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            nums[i] = arr.get(i);
        }

        int n = nums.length;
        int low = 0;
        int high = n - 1;

        // answer variables
        int index = -1;
        int minElement = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[low] <= nums[mid]) {
                if (nums[low] < minElement) {
                    minElement = nums[low];
                    index = low;
                }
                low = mid + 1;
            } else {
                if (nums[mid] < minElement) {
                    minElement = nums[low];
                    index = mid;
                }
                high = mid - 1;
            }


        }
        return index;
    }
}
