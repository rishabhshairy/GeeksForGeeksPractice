package com.codingNinja.top100Tree.hard;

import com.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsBinaryTreeComplete {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (nodeQueue.peek() != null) {
            TreeNode currNode = nodeQueue.poll();
            nodeQueue.offer(currNode.left);
            nodeQueue.offer(currNode.right);
        }
        System.out.println(nodeQueue);
        while (!nodeQueue.isEmpty() && nodeQueue.peek() == null) {
            nodeQueue.poll();
        }
        return nodeQueue.isEmpty();
    }
}
