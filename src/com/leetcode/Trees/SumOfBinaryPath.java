package com.leetcode.Trees;

import java.util.ArrayList;

public class SumOfBinaryPath {
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayList<String> path = new ArrayList<>();
        String pathStr = "";
        int sum = 0;
        solve(root, pathStr, path);

        for (String binaryNum :
                path) {
            sum += Integer.valueOf(binaryNum, 10);
        }
        return sum;
    }

    private void solve(TreeNode root, String pathStr, ArrayList<String> path) {
        if (root.left == null && root.right == null) {
            pathStr += root.val;
            path.add(pathStr);
            pathStr = "";
        }
        pathStr += root.val;
        if (root.left != null) {
            solve(root.left, pathStr, path);
        }
        if (root.right != null) {
            solve(root.right, pathStr, path);
        }

    }
}
