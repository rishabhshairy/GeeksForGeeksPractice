package com.codingNinja.top100Tree.hard;

import com.codingNinja.top100Tree.BinaryTreeNode;

public class BinaryTreePruning {
    public static BinaryTreeNode<Integer> binaryTreePruning(BinaryTreeNode<Integer> root) {
        //Write your code here.
        if (root == null) {
            return null;
        }
        return solve(root);
    }

    private static BinaryTreeNode<Integer> solve(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return null;
        }
        node.left = solve(node.left);
        node.right = solve(node.right);
        if (node.data == 0 && node.left == null && node.right == null) {
            return null;
        }

        return node;
    }
}
