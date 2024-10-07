package com.trees.traversal;

import com.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestLargestBST {
    public static int kthSmallest(TreeNode root, int k) {
        // Write your code here.
        List<Integer> nodeList = new ArrayList<>();
        solve(root, nodeList);
        // for smallest k-1
        // for largest size - 1 -k
        return nodeList.get(k - 1);
    }

    private static void solve(TreeNode root, List<Integer> nodeList) {
        if (root == null) {
            return;
        }
        solve(root.left, nodeList);
        nodeList.add(root.val);
        solve(root.right, nodeList);
    }
}
