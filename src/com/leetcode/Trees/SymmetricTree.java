package com.leetcode.Trees;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return traverse(root, root);
    }

    private boolean traverse(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }

        if (!traverse(leftNode.left, rightNode.right)) {
            return false;
        }
        if (leftNode.val != rightNode.val) {
            return false;
        }
        return traverse(leftNode.right, rightNode.left);
    }
}
