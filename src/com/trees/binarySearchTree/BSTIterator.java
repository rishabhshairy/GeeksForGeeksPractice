package com.trees.binarySearchTree;

import com.trees.TreeNode;

import java.util.Stack;

public class BSTIterator {

    private Stack<TreeNode> nodeStack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }


    public int next() {
        TreeNode temp = nodeStack.pop();
        pushAll(temp.right);
        return temp.val;
    }

    public boolean hasNext() {
        return !nodeStack.isEmpty();
    }

    public void pushAll(TreeNode root) {
        while (root != null) {
            nodeStack.push(root);
            root = root.left;
        }
    }
}
