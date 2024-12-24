package com.leetCode.arrays;

/**
 * LC 3152
 */
public class SpecialArray2 {

    public static void main(String[] args) {
        int[] num = {1};
        int[][] queries = {{0, 0}, {0, 0}};
        SpecialArray2 obj = new SpecialArray2();
        System.out.println(obj.isArraySpecial(num, queries).length);
    }

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        if (nums.length == 1) {
            return new boolean[]{true};
        }
        int n = queries.length;
        boolean[] result = new boolean[n];
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = 0;

        // calculate violative index
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2) {
                prefixSum[i] = prefixSum[i - 1] + 1;
            } else {
                prefixSum[i] = prefixSum[i - 1];
            }
        }

        int index = 0;

        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            result[index++] = prefixSum[end] - prefixSum[start] == 0;
        }
        return result;
    }
}
