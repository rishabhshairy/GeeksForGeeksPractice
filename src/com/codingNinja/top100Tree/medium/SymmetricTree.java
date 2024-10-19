package com.codingNinja.top100Tree.medium;

import com.codingNinja.top100Tree.BinaryTreeNode;

public class SymmetricTree {
    public static boolean isSymmetric(BinaryTreeNode<Integer> root) {
        // Write your code here.
        return root == null || isSymmetricHelp(root.left, root.right);
    }

    private static boolean isSymmetricHelp(BinaryTreeNode<Integer> left, BinaryTreeNode<Integer> right) {
        if (left == null || right == null) {
            return left == right;
        }

        if (!left.data.equals(right.data)) {
            return false;
        }

        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }
}
