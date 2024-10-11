package com.trees.binarySearchTree;

import com.trees.TreeNode;

/**
 * Every Node have a range to check its value
 * starting from [IntMin, IntMax]
 */
public class ValidBSTOptimal {
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean check(TreeNode node, long minValue, long maxValue) {
        if (node == null) {
            return true;
        }

        if (node.val <= minValue || node.val >= maxValue) {
            return false;
        }
        return check(node.left, minValue, node.val) && check(node.right, node.val, maxValue);
    }
}
