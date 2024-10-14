package com.codingNinja.top100Tree;

/**
 * LC Premium
 * You are given a binary tree. Return the count of unival sub-trees in the given binary tree.
 * In unival trees, all the nodes, below the root node, have the same value as the data of the root.
 *
 * GFG --> https://www.geeksforgeeks.org/find-count-of-singly-subtrees/
 */
public class UnivalSubTree {
    public static int countUnivalTrees(BinaryTreeNode<Integer> root) {
        // Write your code here.
        int[] count = {0};
        findUniVal(root, count);
        return count[0];
    }

    private static boolean findUniVal(BinaryTreeNode<Integer> root, int[] count) {
        if (root == null) {
            return true;
        }

        boolean left = findUniVal(root.left, count);
        boolean right = findUniVal(root.right, count);

        if (left && right) {
            if ((root.left != null && !root.data.equals(root.left.data)) ||
                    (root.right != null && !root.data.equals(root.right.data))) {
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }
}
