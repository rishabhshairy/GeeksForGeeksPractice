package com.trees.hard;

import com.trees.TreeNode;

public class CountCompleteNodesInBinaryTree {


    /**
     * Optimal solution --> where we are counting nodes of each subtree
     * 1 + LH + RH
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = findLeftHeight(root);
        int rightHeight = findRightHeight(root);

        // if left and right height is same, it means it's a complete binary tree
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);

    }

    private int findRightHeight(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.right;
        }
        return count;
    }

    private int findLeftHeight(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    /**
     * Brute force solution
     * do inOrder and count nodes
     *
     * @param root
     * @return
     */
    public int countNodesBruteForce(TreeNode root) {
        int[] count = new int[1];
        solveInOrder(root, count);
        return count[0];
    }

    private void solveInOrder(TreeNode root, int[] count) {
        if (root == null) {
            return;
        }
        count[0]++;
        solveInOrder(root.left, count);
        solveInOrder(root.right, count);
    }
}
