package com.trees.hard;

public class UniqueBinaryTree {
    // Each traversal is represented with an integer: preorder - 1, inorder - 2, postorder - 3.

    /**
     * Explanation --> inorder is vvimp to know the left and right of tree
     * we cannot construct unique trees with just roots
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean isPossible(int a, int b) {
        // Code here
        return (a == 2 || b == 2) && a != b;
    }
}
