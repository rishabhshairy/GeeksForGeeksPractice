package com.leetCode.Trees;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    private void solve(TreeNode rootLeft, TreeNode rootRight) {
        if (rootLeft == null || rootRight == null) {
            return;
        }
        if (rootLeft.left != null && rootRight.right != null) {
            TreeNode temp = rootLeft.left;
            rootLeft.left = rootRight.right;
            rootRight.right = temp;

        }

        solve(rootLeft.left, rootRight.right);

    }
}

