package com.leetcode.Trees;

public class KthSamllestBST {
    public int kthSmallest(TreeNode root, int k) {
        int[] res = {0, -1};
        solve(root, k, res);
        return res[1];
    }

    private void solve(TreeNode root, int k, int[] res) {
        if (root == null) {
            return;
        }
        solve(root.left, k, res);
        res[0] += 1;
        if (res[0] == k) {
            res[1] = root.val;
            return;
        }
        solve(root.right, k, res);
        return;
    }
}
