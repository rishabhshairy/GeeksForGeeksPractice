package com.trees.hard;

import com.trees.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class AllNodesAtKDistance {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        // mark parent pointers in a map
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        markParents(root, parentMap);

        // now take a map of visited nodes
        Map<TreeNode, Boolean> visitedNodeMap = new HashMap<>();

        // for level order take a queue
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(target); // remember to start from target
        visitedNodeMap.put(target, true);
        int currLevel = 0;

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            if (currLevel == k) {
                break;
            }
            currLevel++;
            for (int i = 0; i < size; i++) {
                TreeNode currNode = nodeQueue.poll();

                // now go left and right && also check if it's visited

                if (currNode.left != null && visitedNodeMap.get(currNode.left) == null) {
                    nodeQueue.offer(currNode.left);
                    visitedNodeMap.put(currNode.left, true);
                }

                if (currNode.right != null && visitedNodeMap.get(currNode.right) == null) {
                    nodeQueue.offer(currNode.right);
                    visitedNodeMap.put(currNode.right, true);
                }

                // now go in upward direction using parent map
                TreeNode parentNode = parentMap.get(currNode);
                if (parentNode != null && visitedNodeMap.get(parentNode) == null) {
                    nodeQueue.offer(parentNode);
                    visitedNodeMap.put(parentNode, true);
                }
            }
        }

        // once we reach k distance put all the value from queue to list and return
        return nodeQueue.stream().map(node -> node.val).collect(Collectors.toList());
    }

    private void markParents(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode currNode = nodeQueue.poll();
            if (currNode.left != null) {
                // putting key as left and value as parent
                parentMap.put(currNode.left, currNode);
                nodeQueue.offer(currNode.left);
            }

            if (currNode.right != null) {
                parentMap.put(currNode.right, currNode);
                nodeQueue.offer(currNode.right);
            }
        }
    }
}
