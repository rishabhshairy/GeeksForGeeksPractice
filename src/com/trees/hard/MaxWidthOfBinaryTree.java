package com.trees.hard;

import com.trees.TreeNode;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaxWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        Queue<PairMaxWidth> nodeQueue = new LinkedList<>();
        nodeQueue.offer(new PairMaxWidth(root, 0));

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            int mmin = nodeQueue.peek().num;
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                int currLevel = nodeQueue.peek().num - mmin; // to avoid overflow

                TreeNode currNode = nodeQueue.peek().node;
                nodeQueue.poll();
                if (i == 0) {
                    first = currLevel;
                }
                if (i == size - 1) {
                    last = currLevel;
                }

                if (currNode.left != null) {
                    nodeQueue.offer(new PairMaxWidth(currNode.left, currLevel * 2 + 1));
                }
                if (currNode.right != null) {
                    nodeQueue.offer(new PairMaxWidth(currNode.right, currLevel * 2 + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }
}

class PairMaxWidth {
    TreeNode node;
    int num;

    PairMaxWidth(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}
