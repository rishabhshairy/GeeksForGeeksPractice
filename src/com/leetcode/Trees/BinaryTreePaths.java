package com.leetcode.Trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        String outLeft = root.val + "->";
        String outRight = "";
        traverseRootToLeft(root, outLeft, answer);
        return answer;
    }

    private static void traverseRootToLeft(TreeNode root, String outLeft, List<String> answer) {
        if (root == null) {
            System.out.println(outLeft);
            return;
        }
        outLeft += outLeft + root.val + "->";
        traverseRootToLeft(root.left, outLeft, answer);

    }
}
