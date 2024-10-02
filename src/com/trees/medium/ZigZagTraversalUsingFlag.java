package com.trees.medium;

import com.trees.TreeNode;

import java.util.*;

public class ZigZagTraversalUsingFlag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        boolean directionFlag = true;
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            Integer[] levelList = new Integer[size];

            for (int i = 0; i < size; i++) {
                TreeNode node = nodeQueue.poll();

                // below logic handles the direction of insertion into the list
                int index = directionFlag ? i : (size - 1 - i);
                levelList[index] = node.val;

                if (node.left != null) {
                    nodeQueue.offer(node.left);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                }
            }

            directionFlag = !directionFlag;
            result.add(Arrays.asList(levelList));
        }
        return result;
    }

}
