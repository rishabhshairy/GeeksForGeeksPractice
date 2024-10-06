package com.trees.binarySearchTree;

import com.geeksForGeeks.trees.Node;

public class FloorBST {
    public static int floor(Node root, int x) {
        // Code here
        if (root == null) {
            return -1;
        }

        int floor = -1;
        while (root != null) {
            if (root.data == x) {
                floor = x;
                return floor;
            }

            if (x > root.data) {
                floor = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return floor;
    }
}
