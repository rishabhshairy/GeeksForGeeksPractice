package com.trees.binarySearchTree;

import com.geeksForGeeks.trees.Node;

public class MinElementBST {
    int minValue(Node root) {
        // code here
        if (root.left == null) {
            return root.data;
        }
        return minValue(root.left);
    }
}
