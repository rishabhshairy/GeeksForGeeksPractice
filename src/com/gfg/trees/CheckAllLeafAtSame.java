package com.gfg.trees;

public class CheckAllLeafAtSame {
    boolean res;

    boolean check(Node root) {
        res = true;
        solve(root);
        return res;
    }

    private int solve(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = solve(root.left);
        int rightHeight = solve(root.right);

        if (root.left == null && root.right == null && leftHeight != rightHeight) {
            res = false;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
