package com.codingNinja.top100Tree;

public class MergeBinaryTree {

    public static BinaryTreeNode<Integer> mergeTrees(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
        // Write your code here.
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        BinaryTreeNode<Integer> mergedRoot = new BinaryTreeNode<>(root1.data + root2.data);
        mergedRoot.left = mergeTrees(root1.left, root2.left);
        mergedRoot.right = mergeTrees(root1.right, root2.right);
        return mergedRoot;
    }
}
