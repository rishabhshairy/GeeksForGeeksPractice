package com.codingNinja.top100Tree;

public class MaxBinaryTree {
    public static BinaryTreeNode<Integer> constructMaximumBinaryTree(int[] tree, int n) {
        // Write your code here.
        if (n == 0) {
            return null;
        }

        return generateMaxBinaryTree(tree, 0, n - 1);
    }

    private static BinaryTreeNode<Integer> generateMaxBinaryTree(int[] tree, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new BinaryTreeNode<Integer>(tree[start]);
        }

        // create new binary tree
        // find maxIndex in array
        int index = start;
        for (int i = start; i < end; i++) {
            if (tree[index] < tree[i]) {
                index = i;
            }
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(tree[index]);
        root.left = generateMaxBinaryTree(tree, start, index - 1);
        root.right = generateMaxBinaryTree(tree, index + 1, end);
        return root;
    }
}
