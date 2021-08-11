package com.leetcode.Trees;

public class PathSum {
    private boolean hasSum = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int sum = 0;
        solve(root, sum, targetSum);
        return hasSum;
    }

    private TreeNode solve(TreeNode root, int sum, int targetSum) {

        if (root == null) {
            return null;
        }
        sum += root.val;
        TreeNode left = solve(root.left, sum, targetSum);
        TreeNode right = solve(root.right, sum, targetSum);
        if (sum == targetSum && root.left == null && root.right == null) {
            hasSum = true;
        }
        return root;
    }
}
