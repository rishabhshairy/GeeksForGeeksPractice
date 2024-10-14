package com.codingNinja.top100Tree.medium;

import com.codingNinja.top100Tree.BinaryTreeNode;

public class LongestConsecutiveSequence {
    public static int maxPath(BinaryTreeNode<Integer> root) {
        // Write your code here
        if (root == null) {
            return 0;
        }
        int[] count = new int[1];
        solveMaxPath(root, count);
        return count[0];
    }

    private static void solveMaxPath(BinaryTreeNode<Integer> root, int[] count) {
        if (root == null) {
            return;
        }

        if (root.left != null && root.left.data - 1 == root.data) {
            count[0]++;
            solveMaxPath(root.left, count);
        } else if (root.right != null && root.right.data - 1 == root.data) {
            count[0]++;
            solveMaxPath(root.right, count);
        }
    }
}
