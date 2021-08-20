package com.gfg.trees;

import java.util.ArrayList;

public class LeftView {
    static ArrayList<Integer> leftView(Node root) {
        // Your code here
        ArrayList<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        solve(root, answer, 0);
        return answer;

    }

    private static void solve(Node root, ArrayList<Integer> answer, int depth) {
        if (root == null) {
            return;
        }
        if (answer.size() == depth) {
            answer.add(root.data);
        }
        if (root.left != null) {
            solve(root.left, answer, depth + 1);
        }
        if (root.right != null) {
            solve(root.right, answer, depth + 1);
        }
    }
}