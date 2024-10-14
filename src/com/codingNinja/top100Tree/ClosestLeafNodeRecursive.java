package com.codingNinja.top100Tree;

public class ClosestLeafNodeRecursive {

    public static int INF = 1000000;
    private static int ans;

    public static int findClosestLeafNodeDistance(BinaryTreeNode<Integer> root, int x) {
        ans = INF;

        // Calling Helper Function to calculate the closest leaf node for the given node.
        findClosestLeafNodeDistanceHelper(root, x);

        return ans;
    }

    // Helper function to calculate the closest leaf distance of the node.
    public static int findClosestLeafNodeDistanceHelper(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return INF;
        }

        // If the required node is found, calculate the distance of the closest leaf node.
        if (root.data == x) {
            ans = closestLeafNodeInSubtree(root);
            return 0;
        }

        int distLeft = findClosestLeafNodeDistanceHelper(root.left, x);
        if (distLeft != INF) {
            // Node X is present in left subtree.
            int dist = (distLeft + 2) + closestLeafNodeInSubtree(root.right);
            ans = Math.min(ans, dist);
            return (1 + distLeft);
        }

        int distRight = findClosestLeafNodeDistanceHelper(root.right, x);
        if (distRight != INF) {
            // Node X is present in right subtree.
            int dist = (distRight + 2) + closestLeafNodeInSubtree(root.left);
            ans = Math.min(ans, dist);
            return (1 + distRight);
        }

        // Node X not found in the subtree.
        return INF;
    }

    // Function that returns the distance of the closest leaf in the sub tree.
    public static int closestLeafNodeInSubtree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return INF;
        }

        if (root.left == null && root.right == null) {
            // Node is a leaf node.
            return 0;
        }

        int distLeft = closestLeafNodeInSubtree(root.left);
        int distRight = closestLeafNodeInSubtree(root.right);

        return (1 + Math.min(distLeft, distRight));
    }

}
