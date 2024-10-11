package com.trees.binarySearchTree;

import com.trees.TreeNode;

public class LargestBST {
    /**
     * For code 360
     * BruteForce
     *
     * @param root
     * @return
     */
    public static int largestBSTBruteForce(TreeNode root) {
        // First we will check if the Tree is a valid BST or not
        // then for each left and right of tree we will count nodes of valid BST
        int[] maxi = {1};
        checkNode(root, maxi);
        return maxi[0];

    }

    private static void checkNode(TreeNode root, int[] maxi) {
        if (root == null) {
            return;
        }

        if (isBSTValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            int count = countNodes(root);
            maxi[0] = Math.max(maxi[0], count);
        }
        checkNode(root.left, maxi);
        checkNode(root.right, maxi);
    }

    private static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = countNodes(root.left);

        int right = countNodes(root.right);
        return left + right+1;
    }

    private static boolean isBSTValid(TreeNode node, int minValue, int maxValue) {
        if (node == null) {
            return true;
        }

        if (node.val <= minValue || node.val >= maxValue) {
            return false;
        }

        return isBSTValid(node.left, minValue, node.val) && isBSTValid(node.right, node.val, maxValue);
    }
}
