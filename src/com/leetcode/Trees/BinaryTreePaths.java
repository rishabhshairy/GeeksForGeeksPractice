package com.leetcode.Trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        String outRight = "";
        traverseRootToLeft(root, outRight, answer);
        return answer;
    }

    private static void traverseRootToLeft(TreeNode root, String outLeft, List<String> answer) {
        if (root.left == null && root.right == null) {
            answer.add(outLeft + root.val);
            return;
        }
        if(root.left != null){
            traverseRootToLeft(root.left, outLeft + root.val + "->", answer);
        }
        if(root.right != null){
            traverseRootToLeft(root.right, outLeft + root.val + "->", answer);
        }


    }
}
