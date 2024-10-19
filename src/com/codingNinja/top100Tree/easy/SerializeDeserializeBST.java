package com.codingNinja.top100Tree.easy;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBST {

    static class TreeNode<T> {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = right = null;
        }

    }

    public static String serializeTree(TreeNode<Integer> root) {

        if (root == null) {
            return "";
        }
        /**
         * We will use level order traversal here
         */
        Queue<TreeNode<Integer>> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        StringBuilder serializedTree = new StringBuilder();
        while (!nodeQueue.isEmpty()) {
            TreeNode<Integer> currNode = nodeQueue.poll();
            if (currNode == null) {
                serializedTree.append("# ");
                continue;
            }
            serializedTree.append(currNode.data + " ");
            nodeQueue.offer(currNode.left);
            nodeQueue.offer(currNode.right);
        }

        return serializedTree.toString();
    }

    public static TreeNode<Integer> deserializeTree(String data) {

        if (data.equals("")) {
            return null;
        }

        Queue<TreeNode<Integer>> nodeQueue = new LinkedList<>();
        String[] nodesFromData = data.split(" ");
        TreeNode<Integer> root = new TreeNode<>(Integer.parseInt(nodesFromData[0]));
        nodeQueue.offer(root);

        for (int i = 1; i < nodesFromData.length; i++) {
            TreeNode<Integer> parentNode = nodeQueue.poll();

            if (!nodesFromData[i].equals("#")) {
                parentNode.left = new TreeNode<Integer>(Integer.parseInt(nodesFromData[i]));
                nodeQueue.offer(parentNode.left);
            }

            if (!nodesFromData[++i].equals("#")) {
                parentNode.right = new TreeNode<Integer>(Integer.parseInt(nodesFromData[i]));
                nodeQueue.offer(parentNode.right);
            }
        }

        return root;
    }
}
