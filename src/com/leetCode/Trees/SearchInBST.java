package com.leetCode.Trees;

public class SearchInBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }
        return solve(root, val);
    }

    private TreeNode solve(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        if (root.val == val) {
            return root;
        }
        if (val > root.val) {
            return solve(root.right, val);
        } else {
            return solve(root.left, val);
        }
    }
}
