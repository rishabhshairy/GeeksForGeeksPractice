package com.codingNinja.top100Tree.medium;

import java.util.Stack;

public class BSTIterator2 {

    static class TreeNode<T> {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = right = null;
        }

    }

    static Stack<TreeNode<Integer>> nodeStack = new Stack<>();

    BSTIterator2(TreeNode<Integer> root) {
        // Write your code here.
        pushAll(root);
    }

    static void pushAll(TreeNode<Integer> node) {
        while (node != null) {
            nodeStack.push(node);
            node = node.left;
        }
    }

    static int next() {
        // Write your code here.
        TreeNode<Integer> temp = nodeStack.pop();
        pushAll(temp.right);
        return temp.data;
    }

    static boolean hasNext() {
        // Write your code here.
        return !nodeStack.isEmpty();
    }

    static int prev() {
        // Write your code here.
        TreeNode<Integer> temp = nodeStack.pop();
        pushAll(temp.left);
        return temp.data;
    }

    static boolean hasPrev() {
        // Write your code here.
        return !nodeStack.isEmpty();
    }
}
