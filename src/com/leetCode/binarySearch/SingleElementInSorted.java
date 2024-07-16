package com.leetCode.binarySearch;

public class SingleElementInSorted {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4, 4, 8, 8};
    }

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        if (right == 0) {
            return nums[0];
        }

        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if ((nums[mid + 1] != nums[mid]) && (nums[mid - 1] != nums[mid])) {
                return nums[mid];
            }

            if ((mid % 2 != 0 && nums[mid] == nums[mid - 1]) || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int singleNonDuplicateAnotherApproach(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        if (nums[0] != nums[1]) {
            return nums[0];

        }
        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }

        // reducing search space
        int low = 1;
        int high = n - 2;

        while (low <= high) {
            int mid = (low + high) / 2;

            // direct check on mid
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            // check whether we are at even or odd index
            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) ||
                    (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
