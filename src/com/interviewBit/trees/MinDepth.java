package com.interviewBit.trees;

//Given a binary tree, find its minimum depth.
//
//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

public class MinDepth {
    public int minDepth(TreeNode A) {
        if (A == null) {
            return 0;
        }
        return solve(A);
    }

    private int solve(TreeNode a) {
        if (a.right == null && a.left == null) {
            return 1;
        }
        int leftCount = Integer.MAX_VALUE;
        int rightCount = Integer.MAX_VALUE;

        if (a.left != null) {
            leftCount = solve(a.left) + 1;
        }
        if (a.right != null) {
            rightCount = solve(a.right) + 1;
        }
        return Math.min(leftCount, rightCount);
    }
}
