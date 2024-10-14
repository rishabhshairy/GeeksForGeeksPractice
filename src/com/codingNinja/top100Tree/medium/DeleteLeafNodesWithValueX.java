package com.codingNinja.top100Tree.medium;

/**
 * You are given a binary tree, in which the data present in the nodes are integers. You are also given an integer X.
 * <p>
 * Your task is to delete all the leaf nodes with value X. In the process,
 * if the newly formed leaves also have value X, you have to delete them too.
 */
public class DeleteLeafNodesWithValueX {
    public static BinaryTreeNode<Integer> deleteLeafNodes(BinaryTreeNode<Integer> root, int x) {
        //Your code goes here
        if (root == null) {
            return null;
        }

        root.left = deleteLeafNodes(root.left, x);
        root.right = deleteLeafNodes(root.right, x);
        if (root.left == null && root.right == null && root.data == x) {
            return null;
        }
        return root;
    }
}
