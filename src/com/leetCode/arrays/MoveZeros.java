package com.leetCode.arrays;

/**
 * https://leetcode.com/problems/move-zeroes/description/
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 */
public class MoveZeros {
    public static void main(String[] args) {
        MoveZeros obj = new MoveZeros();
        int[] arr = new int[]{0, 1, 0, 3, 1, 2};
        obj.moveZeroes(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


    /**
     * Two pointer
     *
     * @param nums
     */
    public void moveZeroesOptimal(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[slow] != 0 && nums[fast] == 0) {
                swap(nums, slow, fast);
                slow = fast;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    /**
     * Space O(n)
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int zeros = 0;
        int p2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else {
                nums[p2++] = nums[i];
            }
        }
        // fill zeros at end
        for (int i = 0; i < zeros; i++) {
            nums[p2++] = 0;
        }
    }
}
