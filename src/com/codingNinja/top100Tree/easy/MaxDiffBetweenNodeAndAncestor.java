package com.codingNinja.top100Tree.easy;

import com.codingNinja.top100Tree.medium.BinaryTreeNode;

public class MaxDiffBetweenNodeAndAncestor {
    static int maxDiff;

    public static int maxAncestorDiff(BinaryTreeNode<Integer> root) {
        // Write your code here
        maxDiff = (int) 1e9;
        solve(root.left, root.data);
        solve(root.right, root.data);
        return maxDiff;
    }

    private static void solve(BinaryTreeNode<Integer> node, int max) {
        if (node == null) {
            return;
        }

        maxDiff = Math.max(maxDiff, Math.abs(node.data - max));
        max = Math.max(node.data, max);

        solve(node.left, max);
        solve(node.right, max);
    }
}
