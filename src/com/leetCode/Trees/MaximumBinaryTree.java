package com.leetCode.Trees;

public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return construct(nums, 0, nums.length - 1);

    }

    private TreeNode construct(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }

        int maxIndex = start;
        for (int i = start; i < end; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = start;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = construct(nums, start, maxIndex - 1);
        root.right = construct(nums, maxIndex + 1, end);
        return root;
    }


}
