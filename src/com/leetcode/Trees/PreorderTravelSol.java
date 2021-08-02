package com.leetcode.Trees;

import java.util.ArrayList;
import java.util.List;

public class PreorderTravelSol {
    public List<Integer> preorderTraversal(TreeNode root) {
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
        answer.add(root.val);
        traverse(root.left, answer);
        traverse(root.right, answer);
    }
}
