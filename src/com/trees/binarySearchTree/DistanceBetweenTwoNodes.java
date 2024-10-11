package com.trees.binarySearchTree;

import com.trees.TreeNode;

/**
 * @author rshairy
 * Revise again
 * https://www.geeksforgeeks.org/find-distance-between-two-nodes-of-a-binary-tree/
 */
public class DistanceBetweenTwoNodes {

    /**
     * First find the LCA between two given nodes
     *
     * @param root
     * @param node1
     * @param node2
     * @return
     */
    public static int findDistanceBetweenNodes(TreeNode root, int node1, int node2) {
        // Write your code here.
        TreeNode lcaNode = findLCA(root, node1, node2);

        int d1 = findLevel(lcaNode, node1, 0);
        int d2 = findLevel(lcaNode, node2, 0);
        return d1 >= 0 && d2 >= 0 ? d1 + d2 : -1;
    }

    private static int findLevel(TreeNode lcaNode, int key, int level) {
        if (lcaNode == null) {
            return -1;
        }

        if (lcaNode.val == key) {
            return level;
        }

        int leftDistance = findLevel(lcaNode.left, key, level + 1);
        if (leftDistance == -1) {
            return findLevel(lcaNode.right, key, level + 1);
        }
        return leftDistance;
    }

    private static TreeNode findLCA(TreeNode root, int node1, int node2) {
        if (root == null || root.val == node1 || root.val == node2) {
            return root;
        }

        TreeNode left = findLCA(root.left, node1, node2);
        TreeNode right = findLCA(root.right, node1, node2);

        if (left == null && right == null) {
            return null;
        }

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}
