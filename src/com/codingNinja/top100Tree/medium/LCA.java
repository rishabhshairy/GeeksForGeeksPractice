package com.codingNinja.top100Tree.medium;

public class LCA {
    public static int lowestCommonAncestor(BinaryTreeNode<Integer> root, int x, int y) {
        //    Write your code here.
        if (root == null) {
            return -1;
        }
        if (root.data == x || root.data == y) {
            return root.data;
        }

        int left = lowestCommonAncestor(root.left, x, y);
        int right = lowestCommonAncestor(root.right, x, y);

        if (left == -1) {
            return right;
        } else if (right == -1) {
            return left;
        } else {
            return root.data;
        }
    }
}
