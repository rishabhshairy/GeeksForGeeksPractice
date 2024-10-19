package com.codingNinja.top100Tree.hard;

public class MaxPathSumBT {
    static class TreeNode<T> {
        public T val;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public static int maxPathSum(TreeNode<Integer> root) {
        // Write your code here.
        int[] maxSum = {Integer.MIN_VALUE};
        solve(root, maxSum);
        return maxSum[0];
    }

    private static int solve(TreeNode<Integer> root, int[] maxSum) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, solve(root.left, maxSum));
        int right = Math.max(0, solve(root.right, maxSum));
        maxSum[0] = Math.max(maxSum[0], left + right + root.val);
        return root.val + Math.max(left, right);
    }
}
