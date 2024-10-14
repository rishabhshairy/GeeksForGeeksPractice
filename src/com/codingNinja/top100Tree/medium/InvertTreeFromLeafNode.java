package com.codingNinja.top100Tree.medium;

import java.util.ArrayList;

/**
 * You are provided with a Binary Tree and one of its leaf nodes. You have to invert this binary tree.
 * Inversion must be done by following all the below guidelines:
 * <p>
 * • The given leaf node becomes the root after the inversion.
 * <p>
 * • For a node (say, ‘x’)
 * ○ If there exists the left child that is not yet taken then this child must become the right child of ‘x’.
 * ○ If the left child is already taken then the right child is still on the right side of ‘x’.
 * <p>
 * • The parent of ‘x’ must be the left child of ‘x’.
 */
public class InvertTreeFromLeafNode {
    static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static TreeNode<Integer> invertBinaryTree(TreeNode<Integer> root, TreeNode<Integer> leaf) {
        // Write your code here.
        if (root == null) {
            return root;
        }
        ArrayList<TreeNode<Integer>> nodeStack = new ArrayList<>();
        boolean isNewRoot = findNewRoot(root, leaf, nodeStack);
        TreeNode<Integer> newRoot = nodeStack.get(nodeStack.size() - 1);
        nodeStack.remove(nodeStack.size() - 1);
        TreeNode<Integer> parentNode = newRoot;
        TreeNode<Integer> currNode = null;
        while (!nodeStack.isEmpty()) {
            currNode = nodeStack.get(nodeStack.size() - 1);
            nodeStack.remove(nodeStack.size() - 1);
            parentNode.left = currNode;

            if (currNode.left == parentNode) {
                currNode.left = null;

            } else {
                currNode.right = currNode.left;
                currNode.left = null;
            }

            parentNode = parentNode.left;
        }
        return newRoot;
    }

    private static boolean findNewRoot(TreeNode<Integer> node, TreeNode<Integer> leaf, ArrayList<TreeNode<Integer>> nodeStack) {

        nodeStack.add(node);
        // check for leaf node
        if (node.left == null && node.right == null) {
            if (node.data.equals(leaf.data)) {
                return true;
            } else {
                nodeStack.remove(nodeStack.size() - 1);
                return false;
            }
        }
        boolean left = false, right = false;
        if (node.left != null) {
            left = findNewRoot(node.left, leaf, nodeStack);
        }

        if (left) {
            return true;
        }
        if (node.right != null) {
            right = findNewRoot(node.right, leaf, nodeStack);
        }
        if (right) {
            return true;
        }
        nodeStack.remove(nodeStack.size() - 1);
        return false;
    }
}
