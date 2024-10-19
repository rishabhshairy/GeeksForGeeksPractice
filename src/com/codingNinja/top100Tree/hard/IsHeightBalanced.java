package com.codingNinja.top100Tree.hard;

import com.codingNinja.top100Tree.BinaryTreeNode;

public class IsHeightBalanced {

    public static boolean isBalancedBT(BinaryTreeNode<Integer> root) {
        // Write your code here.
        if (root == null) {
            return true;
        }

        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return isBalancedBT(root.left) && isBalancedBT(root.right);
    }

    private static int height(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
