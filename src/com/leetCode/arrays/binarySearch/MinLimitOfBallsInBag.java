package com.leetCode.arrays.binarySearch;

import java.util.Arrays;

public class MinLimitOfBallsInBag {

    /**
     * Similar to koko eating banana
     *
     * @param nums
     * @param maxOperations
     * @return
     */
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();
        int ans = high;

        while (low <= high) {
            int mid = (low + high) / 2;

            int ops = 0;

            // vvimp step --> find ops for each split of nums
            for (int num : nums) {
                ops += (num - 1) / mid;
                if (ops > maxOperations) {
                    break;
                }
            }

            // adjust split size based on size of operation
            if (ops <= maxOperations) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
