package com.slidingwindow.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums and an integer k,
 * return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 */
public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) {
            return false;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int index = 0; index < nums.length; index++) {

            // checking if num already in set
            if (numSet.contains(nums[index])) {
                return true;
            }

            // Adjust window size and remove first element from left
            if (index >= k) {
                int window = index - k;
                numSet.remove(nums[window]);
            }
            numSet.add(nums[index]);
        }

        return false;
    }
}
