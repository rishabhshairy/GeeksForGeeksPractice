package com.trees.medium;

import com.geeksForGeeks.trees.Node;

import java.util.*;

public class TopView {
    static ArrayList<Integer> topView(Node root) {
        // add your code
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TupleTop> nodeQueue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        nodeQueue.offer(new TupleTop(root, 0));

        while (!nodeQueue.isEmpty()) {
            TupleTop currTuple = nodeQueue.poll();
            Node currNode = currTuple.node;
            int currLevel = currTuple.level;

            if (!map.containsKey(currLevel)) {
                map.put(currLevel, currNode.data);
            }

            // now traverse
            if (currNode.left != null) {
                nodeQueue.offer(new TupleTop(currNode.left, currLevel - 1));
            }

            if (currNode.right != null) {
                nodeQueue.offer(new TupleTop(currNode.right, currLevel + 1));
            }
        }
        ArrayList<Integer> nodeList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry :
                map.entrySet()) {
            nodeList.add(entry.getValue());
        }
        return nodeList;
    }
}

class TupleTop {
    Node node;
    int level;

    public TupleTop(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}