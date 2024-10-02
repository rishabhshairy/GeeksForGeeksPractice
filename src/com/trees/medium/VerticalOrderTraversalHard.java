package com.trees.medium;

import com.trees.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Hard question
 */

class Tuple {
    TreeNode node;
    int vertical;
    int level;

    public Tuple(TreeNode node, int vertical, int level) {
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}

public class VerticalOrderTraversalHard {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // define a queue
        Queue<Tuple> nodeQueue = new ArrayDeque<>();
        nodeQueue.offer(new Tuple(root, 0, 0));

        // now define the map to store the other node data
        // priority queue will store the node value
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        while (!nodeQueue.isEmpty()) {
            // get the node to operate
            Tuple currTuple = nodeQueue.poll();
            TreeNode currNode = currTuple.node;
            int vertical = currTuple.vertical;
            int level = currTuple.level;

            // put if current vertical is not in mop
            if (!map.containsKey(vertical)) {
                map.put(vertical, new TreeMap<>());
            }

            // put PQ on current vertical
            if (!map.get(vertical).containsKey(level)) {
                map.get(vertical).put(level, new PriorityQueue<>());
            }

            // now do pre-order traversal
            map.get(vertical).get(level).offer(currNode.val);

            if (currNode.left != null) {
                nodeQueue.offer(new Tuple(currNode.left, vertical - 1, level + 1));
            }
            if (currNode.right != null) {
                nodeQueue.offer(new Tuple(currNode.right, vertical + 1, level + 1));
            }
        }

        // now map the values from priority queue to result list
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> currMap :
                map.values()) {
            result.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : currMap.values()) {
                while (!nodes.isEmpty()) {
                    result.get(result.size() - 1).add(nodes.poll());
                }
            }
        }
        return result;
    }
}
