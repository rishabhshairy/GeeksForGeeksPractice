package com.leetCode.Trees;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }

        if (left.val != right.val) {
            return false;
        }

        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
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
