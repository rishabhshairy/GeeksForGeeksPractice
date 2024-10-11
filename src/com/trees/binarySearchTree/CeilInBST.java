package com.trees.binarySearchTree;

import com.geeksForGeeks.trees.Node;

public class CeilInBST {
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        // Code here
        int ceil = -1;
        while (root != null) {
            if (root.data == key) {
                ceil = root.data;
                return ceil;
            }

            // traverse logic
            if (key > root.data) {
                root = root.right;
            } else {
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }
}
