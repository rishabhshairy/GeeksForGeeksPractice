package com.interviewbit.trees;

public class LCA {
    public int lca(TreeNode root, int B, int C) {
        if (root == null) {
            return -1;
        }
        if (B == C) {
            return B;
        }
        if (root.val == B || root.val == C) {
            return root.val;
        }

        int left = lca(root.left, B, C);
        int right = lca(root.right, B, C);

        if (left != -1 && right != -1) {
            return root.val;
        }

        if (left == -1 && right == -1) {
            return root.val;
        }

        return left != -1 ? left : right;
    }
}
