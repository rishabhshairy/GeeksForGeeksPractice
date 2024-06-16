package com.leetCode.Trees;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        int[] arr = new int[1];
        solve(root, arr);
        return arr[0];
    }

    private void solve(TreeNode root, int[] arr) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                int sum = arr[0];
                sum += root.left.val;
                arr[0] = sum;
            }
            solve(root.left, arr);
        }
        solve(root.right, arr);
    }
}
