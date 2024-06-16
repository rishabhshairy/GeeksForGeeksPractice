package com.leetCode.Trees;

import java.util.ArrayList;
import java.util.List;

public class PostorderTravelSol {
    public List<Integer> postorderTraversal(TreeNode root) {
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
        traverse(root.right, answer);
        answer.add(root.val);
    }
}
