package com.codingNinja.top100Tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextNode {
    static class TreeNode<T> {
        public T val;
        public TreeNode<T> left;
        public TreeNode<T> right;
        public TreeNode<T> next;

        TreeNode(T val) {
            this.val = val;
            left = null;
            right = null;
            next = null;
        }
    }

    public static void connectNext(TreeNode<Integer> root) {
        // Write your code here
        if (root == null) {
            return;
        }

        Queue<TreeNode<Integer>> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();

            for (int i = 0; i < size; i++) {
                TreeNode<Integer> currNode = nodeQueue.peek();

                if (currNode.left != null) {
                    nodeQueue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    nodeQueue.offer(currNode.right);
                }

                TreeNode<Integer> polledNode = nodeQueue.poll();
                if (i != size - 1) {
                    polledNode.next = nodeQueue.peek();
                }
            }
        }
    }
}
