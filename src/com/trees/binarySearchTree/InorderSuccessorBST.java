package com.trees.binarySearchTree;

import com.geeksForGeeks.trees.Node;

public class InorderSuccessorBST {

    /**
     * for successor , check if x.val >= root.val and move right
     * 
     * @param root
     * @param x
     * @return
     */
    public Node inorderSuccessor(Node root, Node x) {
        //add code here.
        if (root == null) {
            return null;
        }
        Node successor = null;
        while (root != null) {
            if (x.data >= root.data) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }

    /**
     * For predecessor check for root.val >= x.val and move left
     * @param root
     * @param x
     * @return
     */
    public Node inorderPredecessor(Node root, Node x) {
        //add code here.
        if (root == null) {
            return null;
        }
        Node predecessor = null;
        while (root != null) {
            if (root.data >= x.data) {
                root = root.left;
            } else {
                predecessor = root;
                root = root.right;
            }
        }
        return predecessor;
    }
}
