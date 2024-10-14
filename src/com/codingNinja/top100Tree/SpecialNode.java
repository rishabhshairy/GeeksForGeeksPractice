package com.codingNinja.top100Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SpecialNode {
    static class TreeNode<T> {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static ArrayList<Integer> findSpecialNodes(TreeNode<Integer> root) {
        // Write your code here.
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode<Integer>> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> currNode = nodeQueue.poll();

                if (currNode.left != null) {
                    nodeQueue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    nodeQueue.offer(currNode.right);
                }

                if (currNode.left != null && currNode.right == null) {
                    result.add(currNode.left.data);

                }
                if (currNode.left == null && currNode.right != null) {
                    result.add(currNode.right.data);
                }
            }
        }
        return result;
    }
}
