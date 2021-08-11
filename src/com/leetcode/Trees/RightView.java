package com.leetcode.Trees;

import java.util.ArrayList;
import java.util.List;

public class RightView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> answer = new ArrayList<>();
        solve(root, answer, 0);
        return answer;
    }

    private void solve(TreeNode root, List<Integer> answer, int depth) {
        if (root == null) {
            return;
        }
        if (answer.size()==depth) {
            answer.add(root.val);
        }
        solve(root.right, answer, depth + 1);
        solve(root.left, answer, depth + 1);
    }
}
