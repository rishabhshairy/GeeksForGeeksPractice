package com.leetcode.Trees;

import java.util.ArrayList;
import java.util.List;

public class InorderTravelSol {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        traverse(root, answer);
        return answer;
    }

    private static void traverse(TreeNode root, List<Integer> answer) {
        if (root == null) {
            return;
        }
        traverse(root.left, answer);
        answer.add(root.val);
        traverse(root.right, answer);
    }
}
