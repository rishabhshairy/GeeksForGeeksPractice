package com.codingNinja.top100Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxLevelSum {
    public static int maxLevelSum(BinaryTreeNode<Integer> root) {
        // Write your code here.
        int maxi = Integer.MIN_VALUE;
        Queue<BinaryTreeNode<Integer>> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {

                BinaryTreeNode<Integer> currNode = nodeQueue.poll();

                if (currNode.left != null) {
                    nodeQueue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    nodeQueue.offer(currNode.right);
                }
                sum += currNode.data;
            }

            maxi = Math.max(maxi, sum);
        }
        
        return maxi;
    }
}
