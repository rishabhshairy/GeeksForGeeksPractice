package com.codingNinja.top100Tree.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ClosestLeafToGivenNode {

    /**
     *
     * @param root
     * @param x
     * @return
     */
    public static int findClosestLeafNodeDistanceBFS(BinaryTreeNode<Integer> root, int x) {
        // Write your code here.
        if (root == null) {
            return 0;
        }
        Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parentMap = new HashMap<>();
        BinaryTreeNode<Integer> source = markParent(root, parentMap, x);
        if (source == null) {
            return -1;
        }

        // now traverse from source to leaf
        int level = 0;
        int ans = Integer.MAX_VALUE;
        Map<BinaryTreeNode<Integer>, Boolean> visited = new HashMap<>();
        Queue<BinaryTreeNode<Integer>> nodeQueue = new LinkedList<>();
        nodeQueue.offer(source);
        visited.put(source, true);

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();

            for (int i = 0; i < size; i++) {
                BinaryTreeNode<Integer> currNode = nodeQueue.poll();

                // check if leaf node is at current level
                if (currNode.left == null && currNode.right == null) {
                    ans = Math.min(ans, level);
                }

                // visit left, right parent
                if (currNode.left != null && visited.get(currNode.left) == null) {
                    visited.put(currNode.left, true);
                    nodeQueue.offer(currNode.left);
                }

                if (currNode.right != null && visited.get(currNode.right) == null) {
                    visited.put(currNode.right, true);
                    nodeQueue.offer(currNode.right);
                }

                BinaryTreeNode<Integer> parentNode = parentMap.get(currNode);
                if (parentNode != null && visited.get(parentNode) == null) {
                    visited.put(parentNode, true);
                    nodeQueue.offer(parentNode);
                }
            }
            level++;
        }

        return ans;

    }

    private static BinaryTreeNode<Integer> markParent(BinaryTreeNode<Integer> root, Map<BinaryTreeNode<Integer>,
                                                    BinaryTreeNode<Integer>> parentMap, int x) {
        Queue<BinaryTreeNode<Integer>> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        BinaryTreeNode<Integer> sourceNode = null;
        while (!nodeQueue.isEmpty()) {
            BinaryTreeNode<Integer> currNode = nodeQueue.poll();

            if (currNode.data == x) {
                sourceNode = currNode;
            }

            if (currNode.left != null) {
                parentMap.put(currNode.left, currNode);
                nodeQueue.offer(currNode.left);
            }

            if (currNode.right != null) {
                parentMap.put(currNode.right, currNode);
                nodeQueue.offer(currNode.right);
            }
        }

        return sourceNode;
    }
}
