package com.trees.hard;

import com.trees.TreeNode;

import java.util.Stack;

public class FlattenBinaryTreeOptimal {

    TreeNode prev = null;

    /**
     * Re-arrange in-between the nodes
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    /**
     * Below is iterative solution
     */
    public static TreeNode flattenBinaryTree(TreeNode root) {
        // Write your code here.
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {
            TreeNode currNode = nodeStack.peek();
            nodeStack.pop();

            if (currNode.right != null) {
                nodeStack.push(currNode.right);
            }
            if (currNode.left != null) {
                nodeStack.push(currNode.left);
            }

            if (!nodeStack.isEmpty()) {
                currNode.right = nodeStack.peek();
            }
            currNode.left = null;
        }
        return root;
    }
}
