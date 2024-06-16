package com.geeksForGeeks.trees;

public class ToSumTree {
    public void toSumTree(Node root) {
        //add code here.
        solve(root);
    }

    private int solve(Node root) {
        if (root == null) {
            return 0;
        }
        int prev = root.data;
        root.data = solve(root.left) + solve(root.right);
        return root.data + prev;
    }

}
