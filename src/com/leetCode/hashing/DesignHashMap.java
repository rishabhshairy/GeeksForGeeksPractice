package com.leetCode.hashing;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Design actual hashmap
 */
public class DesignHashMap {

    static final int SIZE = 1000;
    List<Node>[] nodeMap;

    public DesignHashMap() {
        nodeMap = new List[SIZE];
        for (int i = 0; i < SIZE; i++) {
            nodeMap[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        List<Node> bucket = getBucket(key);
        for (Node node : bucket) {
            if (node.key == key) {
                node.val = value;
                return;
            }
        }
        bucket.add(new Node(key, value));
    }

    public int get(int key) {

        List<Node> bucket = getBucket(key);
        for (Node node : bucket) {
            if (node.key == key) {
                return node.val;
            }
        }
        return -1;
    }

    public void remove(int key) {
        List<Node> bucket = getBucket(key);
        Iterator<Node> nodeIterator = bucket.iterator();
        while (nodeIterator.hasNext()) {
            Node node = nodeIterator.next();
            if (node.key == key) {
                nodeIterator.remove();
                return;
            }
        }
    }

    private List<Node> getBucket(int key) {
        int index = hash(key);
        return nodeMap[index];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    static class Node {
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
