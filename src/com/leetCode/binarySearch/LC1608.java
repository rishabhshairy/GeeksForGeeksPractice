package com.leetCode.binarySearch;

import java.util.Arrays;
import java.util.HashMap;

public class LC1608 {
    public static void main(String[] args) {
        int[] arr = {0, 4, 3, 0, 4};
//        int[] arr = {3,5};
        System.out.println(specialArray(arr));
    }

    /**
     * Binary Search Approach
     * Range will be from 1 to N
     * Now find index where range is greater or equals
     *
     * @param nums
     * @return
     */
    public static int specialArray(int[] nums) {
        Arrays.sort(nums);

        for (int rangeVal = 1; rangeVal <= nums.length; rangeVal++) {
            int lowerBoundIndex = findLowerBound(nums, rangeVal);
            if (nums.length - lowerBoundIndex == rangeVal) {
                return rangeVal;
            }
        }
        return -1;
    }

    private static int findLowerBound(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int index = nums.length; // assuming max element will be the least index value

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }


    public static int specialArrayBruteForce(int[] nums) {
        int maxCount = -1;

        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1 && nums[0] != 0) {
            return 1;
        } else if (nums.length == 1 && nums[0] == 0) {
            return 0;
        }

        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 1; i < 1001; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] >= i) {
                    countMap.put(i, countMap.getOrDefault(i, 0) + 1);
                }
            }
        }
        for (Integer key :
                countMap.keySet()) {
            if (countMap.get(key).equals(key)) {
                return key;
            }
        }

        return maxCount;
    }
}
