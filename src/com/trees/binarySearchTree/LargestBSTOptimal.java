package com.trees.binarySearchTree;

import com.geeksForGeeks.trees.Node;

public class LargestBSTOptimal {
    static int largestBst(Node root) {
        // Write your code here
        return largestBstUtil(root).maxSize;
    }

    /**
     * Doing a reverse post-order
     *
     * @param node
     * @return
     */
    private static NodeVal largestBstUtil(Node node) {

        if (node == null) {
            return new NodeVal(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        NodeVal right = largestBstUtil(node.right);
        NodeVal left = largestBstUtil(node.left);

        if (left.maxValue < node.data && node.data < right.minValue) {
            return new NodeVal(Math.min(node.data, left.minValue),
                    Math.max(node.data, right.maxValue),
                    left.maxSize + right.maxSize + 1);
        }

        return new NodeVal(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }
}

class NodeVal {
    int minValue;
    int maxValue;
    int maxSize;

    public NodeVal(int minValue, int maxValue, int maxSize) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.maxSize = maxSize;
    }
}