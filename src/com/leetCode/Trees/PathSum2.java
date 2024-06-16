package com.leetCode.Trees;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        int sum = 0;
        List<Integer> path = new ArrayList<>();
        solve(root, sum, targetSum, path, answer);
        return answer;
    }

    private void solve(TreeNode root, int sum, int targetSum, List<Integer> leftSum, List<List<Integer>> answer) {
        if (root == null) {
            return;
        }
        sum += root.val;
        leftSum.add(root.val);
        if (sum == targetSum && root.left == null && root.right == null) {
            answer.add(new ArrayList<>(leftSum));
            return;
        }
        if (root.left != null) {
            solve(root.left, sum, targetSum, leftSum, answer);
            leftSum.remove(leftSum.size() - 1);
        }
        if (root.right != null) {
            solve(root.right, sum, targetSum, leftSum, answer);
            leftSum.remove(leftSum.size() - 1);
        }
    }
}
