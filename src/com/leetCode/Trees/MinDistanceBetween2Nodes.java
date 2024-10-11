package com.leetCode.Trees;

public class MinDistanceBetween2Nodes {
    TreeNode prev = null;

    public int minDiffInBST(TreeNode root) {
        int[] mini = {Integer.MAX_VALUE};
        solve(root, mini);
        return mini[0];
    }

    private void solve(TreeNode root, int[] mini) {
        if (root == null) {
            return;
        }
        solve(root.left, mini);
        if (prev != null) {
            int diff = root.val - prev.val;
            mini[0] = Math.min(mini[0], diff);
        }
        prev = root;
        solve(root.right, mini);
    }
}
