package com.leetCode.bitManipulation;

/**
 * 3097. Shortest Subarray With OR at Least K II
 * You are given an array nums of non-negative integers and an integer k.
 * <p>
 * An array is called special if the bitwise OR of all of its elements is at least k.
 * <p>
 * Return the length of the shortest special non-empty
 * subarray
 * of nums, or return -1 if no special subarray exists.
 */
public class LC3097 {

    public static void main(String[] args) {
        int[] num = {2,1,9,12};
        LC3097 obj = new LC3097();
        System.out.println(obj.minimumSubarrayLength(num, 21));
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int[] bitCount = new int[32];

        while (right < nums.length) {
            updateBitCount(bitCount, nums[right], 1);
            while (left <= right && convertBitToNums(bitCount) >= k) {
                minLen = Math.min(minLen, right - left + 1);

                // remove the left position from window
                updateBitCount(bitCount, nums[left], -1);
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    private int convertBitToNums(int[] bitCount) {
        int result = 0;
        for (int i = 0; i < bitCount.length; i++) {
            if (bitCount[i] != 0) {
                result |= (1 << i);
            }
        }
//        System.out.println(result);
        return result;
    }

    /**
     * @param bitCount
     * @param num
     * @param delta    -- being used to increase and decrease the count
     */
    private void updateBitCount(int[] bitCount, int num, int delta) {
        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) != 0) {
                bitCount[i] += delta;
            }
        }
    }
}
