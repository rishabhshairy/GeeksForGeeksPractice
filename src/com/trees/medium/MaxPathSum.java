package com.trees.medium;

import com.trees.TreeNode;

public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        solveMaxPathSum(root, maxSum);
        return maxSum[0];
    }

    private int solveMaxPathSum(TreeNode node, int[] maxSum) {
        if (node == null) {
            return 0;
        }

        int leftSum = Math.max(0, solveMaxPathSum(node.left, maxSum)); // done to avoid taking negative values
        int rightSum = Math.max(0, solveMaxPathSum(node.right, maxSum)); // done to avoid taking negative values
        maxSum[0] = Math.max(maxSum[0], leftSum + rightSum + node.val);
        return node.val + Math.max(leftSum, rightSum);
    }
}
