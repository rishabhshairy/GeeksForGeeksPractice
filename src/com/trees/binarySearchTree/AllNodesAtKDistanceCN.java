package com.trees.binarySearchTree;

import com.codingNinja.top100Tree.BinaryTreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class AllNodesAtKDistanceCN {

    // we will use concept of parent map here and store all the parent nodes
    // mark visited
    public static List<BinaryTreeNode<Integer>> printNodesAtDistanceK(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> target, int K) {
        // Write your code here.
        List<BinaryTreeNode<Integer>> result = new ArrayList<>();
        Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parentMap = new HashMap<>();
        parentMap(root, parentMap);

        // create a visited map and queue to traverse
        Queue<BinaryTreeNode<Integer>> nodeQueue = new LinkedList<>();
        Map<BinaryTreeNode<Integer>, Boolean> visited = new HashMap<>();
        nodeQueue.offer(target);
        visited.put(target, true);
        int currDistance = 0;

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            if (currDistance == K) {
                break;
            }
            currDistance++;

            for (int i = 0; i < size; i++) {
                BinaryTreeNode<Integer> currNode = nodeQueue.peek();
                nodeQueue.poll();

                // check for left , right and upward
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
        }

        result = nodeQueue.stream().collect(Collectors.toList());
        return result;
    }

    private static void parentMap(BinaryTreeNode<Integer> node, Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parentMap) {
        Queue<BinaryTreeNode<Integer>> nodeQueue = new LinkedList<>();
        nodeQueue.offer(node);

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode<Integer> currNode = nodeQueue.poll();
                if (currNode.left != null) {
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
}
