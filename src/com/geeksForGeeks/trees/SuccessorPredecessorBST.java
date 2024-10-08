package com.geeksForGeeks.trees;

public class SuccessorPredecessorBST {
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        // code here.
        // update pre[0] with the predecessor of the key
        // update suc[0] with the successor of the key
        pre[0] = inorderPredecessor(root, new Node(key));
        suc[0] = inorderSuccessor(root, new Node(key));
    }

    public static Node inorderSuccessor(Node root, Node x) {
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

    public static Node inorderPredecessor(Node root, Node x) {
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
