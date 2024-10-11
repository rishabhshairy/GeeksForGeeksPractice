package com.trees.hard;

import com.geeksForGeeks.trees.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BurnTreeFromNode {
    public static int minTime(Node root, int target) {
        // Your code goes here
        if (root == null) {
            return 0;
        }

        // key --> currNode .... value --> parentNode
        Map<Node, Node> parentMap = new HashMap<>();
        Node targetNode = bfsMapToParent(root, parentMap, target);

        // now since we have the target node do a BFS traversal from that node
        Queue<Node> nodeQueue = new LinkedList<>();
        Map<Node, Boolean> visitedMap = new HashMap<>();

        nodeQueue.offer(targetNode);
        visitedMap.put(targetNode, true);
        int time = 0;


        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            boolean visited = false;

            for (int i = 0; i < size; i++) {
                Node currNode = nodeQueue.poll();
                // now burn left, right and upward
                if (currNode.left != null && visitedMap.get(currNode.left) == null) {
                    visited = true;
                    visitedMap.put(currNode.left, visited);
                    nodeQueue.offer(currNode.left);
                }

                if (currNode.right != null && visitedMap.get(currNode.right) == null) {
                    visited = true;
                    visitedMap.put(currNode.right, visited);
                    nodeQueue.offer(currNode.right);
                }
                // now check for parents
                Node parentNode = parentMap.get(currNode);
                if (parentNode != null && visitedMap.get(parentNode) == null) {
                    visited = true;
                    visitedMap.put(parentNode, visited);
                    nodeQueue.offer(parentNode);
                }
            }
            if (visited) {
                time++;
            }
        }
        return time;
    }

    private static Node bfsMapToParent(Node root, Map<Node, Node> parentMap, int target) {
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        // take target node since we are given node value
        Node targetNode = new Node(-1);
        // now do BFS traversal and mark parent nodes

        while (!nodeQueue.isEmpty()) {
            Node currNode = nodeQueue.poll();
            if (currNode.data == target) {
                targetNode = currNode;
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
        return targetNode;
    }
}
