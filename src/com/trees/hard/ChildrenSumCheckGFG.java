package com.trees.hard;

import com.geeksForGeeks.trees.Node;

public class ChildrenSumCheckGFG {
    public static int isSumProperty(Node root) {
        // add your code here
        if (root == null) {
            return 1;
        }

        return checkTree(root) ? 1 : 0;

    }

    private static boolean checkTree(Node node) {

        if (node == null || node.left == null && node.right == null) {
            return true;
        }

        boolean leftCheck = checkTree(node.left);
        boolean rightCheck = checkTree(node.right);

        if (node.left == null && node.right.data != node.data) {
            return false;
        }

        if (node.right == null && node.left.data != node.data) {
            return false;
        }

        if (node.left != null && node.right != null && node.left.data + node.right.data != node.data) {
            return false;
        }

        return leftCheck && rightCheck;
    }
}
