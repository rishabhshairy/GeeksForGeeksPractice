package com.leetCode.DP;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 2};
        System.out.println(longestConsecutiveBruteForce(arr));
    }


    public static int longestConsecutiveOptimal(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int longest = 1;

        Set<Integer> numSet = new LinkedHashSet<>();

        for (int num :
                nums) {
            numSet.add(num);
        }

        for (Integer currNum :
                numSet) {
            if (!numSet.contains(currNum - 1)) {
                int x = currNum;
                int currLongest = 1;

                while (numSet.contains(x + 1)) {
                    x++;
                    currLongest++;
                }
                longest = Math.max(longest, currLongest);
            }
        }
        return longest;
    }

    public static int longestConsecutiveSortApproach(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int longest = 1;
        int lastSmall = Integer.MIN_VALUE;
        int currLongest = 0;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 == lastSmall) {
                currLongest++;
                lastSmall = nums[i];
            } else if (nums[i] != lastSmall) {
                currLongest = 1;
                lastSmall = nums[i];
            }
            longest = Math.max(longest, currLongest);
        }
        return longest;
    }

    /**
     * =
     * Pick an element X and do linear search if X+1 , X+2 ... exists
     *
     * @param nums
     * @return
     */
    public static int longestConsecutiveBruteForce(int[] nums) {
        int longest = 1;

        if (nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            int currLongest = 1;
            int x = nums[i];
            while (searchElement(nums, x + 1)) {
                x++;
                currLongest++;
            }
            longest = Math.max(longest, currLongest);
        }
        return longest;
    }

    private static boolean searchElement(int[] nums, int x) {
        boolean found = false;
        for (int i = 0; i < nums.length; i++) {
            if (x == nums[i]) {
                found = true;
                break;
            }
        }
        return found;
    }
}
