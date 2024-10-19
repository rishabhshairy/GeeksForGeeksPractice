package com.codingNinja.top100Tree.hard;

import com.trees.TreeNode;

public class MaxWidth {
    public static int getMaxWidth(TreeNode root) {
        // Write your code here.
        int max = 0;
        int height = maxDepth(root);

        // now go till max height of tree

        for (int i = 0; i < height; i++) {
            int nodes = width(root, i);
            max = Math.max(nodes, max);
        }
        return max;
    }

    private static int width(TreeNode root, int depth) {
        if (root == null) {
            return 0;
        } else {
            if (depth == 0) {
                return 1;
            } else {
                return width(root.left, depth - 1) + width(root.right, depth - 1);
            }
        }
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }
}
