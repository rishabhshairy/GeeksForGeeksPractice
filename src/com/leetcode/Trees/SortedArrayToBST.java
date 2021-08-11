package com.leetcode.Trees;

import java.util.Arrays;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int midIndex = nums.length / 2;
        TreeNode root = new TreeNode(nums[midIndex]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, midIndex));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, midIndex + 1, nums.length));
        return root;

    }
}
