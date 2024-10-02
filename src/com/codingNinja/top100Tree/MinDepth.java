package com.codingNinja.top100Tree;

public class MinDepth {

    public static int minDepth(BinaryTreeNode<Integer> root) {
        // Write your code here.
        return findMinDepth(root);
    }

    private static int findMinDepth(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return 0;
        }

        int left = findMinDepth(node.left);
        int right = findMinDepth(node.right);
        if (left == 0 || right == 0) {
            return 1 + left + right;
        }
        return 1 + Math.min(left, right);
    }
}
