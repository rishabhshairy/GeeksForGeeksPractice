package com.codingNinja.top100Tree.medium;

import com.codingNinja.top100Tree.BinaryTreeNode;

public class PartialBST {
    /**
     * Brute Force will be to write inorder and check if the array is sorted
     *
     * @param root
     * @return
     */
    public static boolean validateBST(BinaryTreeNode<Integer> root) {
        // Write your code here
        return isPartialBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Concept being used is
     * for left subTree max will root
     * and for right subtree min will root
     *
     * @param root
     * @param minValue
     * @param maxValue
     * @return
     */
    private static boolean isPartialBst(BinaryTreeNode<Integer> root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }

        if (root.data >= minValue && root.data <= maxValue) {

            boolean left = isPartialBst(root.left, minValue, root.data);
            boolean right = isPartialBst(root.right, root.data, maxValue);
            return left && right;
        }
        return false;
    }
}
