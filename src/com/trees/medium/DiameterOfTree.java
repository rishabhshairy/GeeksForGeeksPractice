package com.trees.medium;

import com.trees.TreeNode;

/**
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 */
public class DiameterOfTree {


    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxi = new int[1]; // using bcoz in java variables are not passed by reference
        dfsMaxHeight(root, maxi);
        return maxi[0];
    }

    private int dfsMaxHeight(TreeNode root, int[] maxi) {
        if (root == null) {
            return 0;
        }

        int leftHeight = dfsMaxHeight(root.left, maxi);
        int rightHeight = dfsMaxHeight(root.right, maxi);
        maxi[0] = Math.max(maxi[0], leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);

    }

    /**
     * Brute force solution
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTreeBruteForce(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        int leftToRoot = diameterOfBinaryTreeBruteForce(root.left);
        int rightToRoot = diameterOfBinaryTreeBruteForce(root.right);
        return Math.max(leftHeight + rightHeight, Math.max(leftToRoot, rightToRoot));

    }

    private int findHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        int left = findHeight(node.left);
        int right = findHeight(node.right);

        return 1 + Math.max(left, right);
    }
}
