package com.trees.medium;

import com.geeksForGeeks.trees.Node;

import java.util.*;

public class BottomView {
    public ArrayList<Integer> bottomView(Node root) {
        // Code here
        if (root == null) {
            return new ArrayList<>();
        }

        //  store level as key and node->data as value
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<TupleBottom> nodeQueue = new LinkedList<>();
        nodeQueue.offer(new TupleBottom(root, 0));

        while (!nodeQueue.isEmpty()) {
            TupleBottom currTuple = nodeQueue.poll();
            Node currNode = currTuple.node;
            int currLevel = currTuple.level;
            map.put(currLevel, currNode.data);

            // now traverse
            if (currNode.left != null) {
                nodeQueue.offer(new TupleBottom(currNode.left, currLevel - 1));
            }

            if (currNode.right != null) {
                nodeQueue.offer(new TupleBottom(currNode.right, currLevel + 1));
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

class TupleBottom {
    Node node;
    int level;

    public TupleBottom(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}