package com.leetCode.Trees.med;

import com.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BottomLeftValOfTree {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        int leftMost = -1;

        while (!nodeQueue.isEmpty()) {
            TreeNode currNode = nodeQueue.poll();
            leftMost = currNode.val;

            if (currNode.right != null) {
                nodeQueue.offer(currNode.right);
            }
            if (currNode.left != null) {
                nodeQueue.offer(currNode.left);
            }
        }
        return leftMost;
    }
}
