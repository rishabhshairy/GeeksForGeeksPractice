package com.codingNinja.top100Tree;

public class MirrorTree {

    public static void mirrorTree(BinaryTreeNode<Integer> node) {
        // Write your code here.
        findMirror(node);
    }

    private static BinaryTreeNode<Integer> findMirror(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return null;
        }

        BinaryTreeNode<Integer> left = findMirror(node.left);
        BinaryTreeNode<Integer> right = findMirror(node.right);

        BinaryTreeNode<Integer> temp = left;
        node.left = right;
        node.right = temp;
        return node;
    }
}
