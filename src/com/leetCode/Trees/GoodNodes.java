package com.leetCode.Trees;

public class GoodNodes {
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int[] arr = new int[1];
        solve(root, arr, root.val);
        return arr[0];
    }

    private void solve(TreeNode root, int[] arr, int val) {
        if (root == null) {
            return;
        }

        if (root.val >= val) {
            arr[0]++;
        }
        solve(root.left, arr, Math.max(val, root.val));
        solve(root.right, arr, Math.max(val, root.val));
    }
}
