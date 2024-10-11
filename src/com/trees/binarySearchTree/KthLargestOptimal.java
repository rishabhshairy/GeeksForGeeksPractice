package com.trees.binarySearchTree;

import com.geeksForGeeks.trees.Node;

/**
 * Do reverse inorder and find kth largest
 * use same counter logic
 */
public class KthLargestOptimal {
    public int kthLargest(Node root, int k) {
        //Your code here
        int[] count = new int[1];
        int[] largest = new int[1];
        findLargest(root, count, largest, k);
        return largest[0];
    }

    private void findLargest(Node node, int[] count, int[] largest, int k) {
        if (node == null) {
            return;
        }

        findLargest(node.right, count, largest, k);

        count[0]++;
        if (count[0] == k) {
            largest[0] = node.data;
            return;
        }

        findLargest(node.left, count, largest, k);
    }
}
