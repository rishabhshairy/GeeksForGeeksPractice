package com.trees.traversal;

import com.trees.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>();
        if (root == null) {
            return levelList;
        }

        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            int levelNum = nodeQueue.size();
            List<Integer> levelNodeList = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                // check for left and right child
                if (nodeQueue.peek().left != null) {
                    nodeQueue.offer(nodeQueue.peek().left);
                }
                if (nodeQueue.peek().right != null) {
                    nodeQueue.offer(nodeQueue.peek().right);
                }
                levelNodeList.add(nodeQueue.poll().val);
            }
            levelList.add(levelNodeList);
        }
        levelList.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
        Collections.emptyList();
        return levelList;
    }
}
