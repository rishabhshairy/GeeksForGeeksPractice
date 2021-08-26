package com.leetcode.DP;

public class MaxLengthOfRepeatedSubArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 2, 1};
        int[] arr2 = {3, 2, 1, 4, 7};
        System.out.println(findLength(arr1, arr2));
    }

    public static int findLength(int[] nums1, int[] nums2) {
        if (nums1==null || nums2==null){
            return 0;
        }
        int m = nums1.length;
        int n = nums2.length;
        int maxLen = 0;
        int[][] tdp = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    tdp[i][j] = 0;
                } else {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        tdp[i][j] = 1 + tdp[i - 1][j - 1];
                        maxLen = Math.max(maxLen, tdp[i][j]);
                    }
                }
            }
        }
        return maxLen;
    }
}
