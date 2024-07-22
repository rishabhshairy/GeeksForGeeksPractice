package com.leetCode.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC -- 2089
 */
public class FindTargetIndices {
    public static void main(String[] args) {
        int[] arr2 = {1, 2, 2, 3, 2, 2, 4, 5, 2, 3};
//        int[] arr2 = {100,1,100};
        //int[] arr2 = {1, 2, 5, 2, 3};
        System.out.println(targetIndices(arr2, 5));
    }

    /**
     * Use lower and upper bound to find indexes
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        List<Integer> result = new ArrayList<>();

        int low = findLowerBound(nums, target);
        int high = findUpperBound(nums, target);

        System.out.println(low);
        System.out.println(high);


        if (low == -1 && high == -1) {
            return result;
        }
        if (low != -1 && high - low == 0) {
            result.add(low);
            return result;
        }
        if (high - low > 0) {
            for (int i = low; i <= high; i++) {
                result.add(i);
            }
        }
        return result;
    }

    public static int findLowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1; // setting hypothetical answer if we dont find any such number

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                ans = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int findUpperBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1; // setting hypothetical answer if we dont find any such number

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                ans = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
