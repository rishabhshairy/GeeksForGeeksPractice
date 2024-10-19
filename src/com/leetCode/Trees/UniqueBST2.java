package com.leetCode.Trees;

import java.util.ArrayList;
import java.util.List;

public class UniqueBST2 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        return generateAllTree(1, n);
    }

    private List<TreeNode> generateAllTree(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if (start > end) {
            trees.add(null);
            return trees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = generateAllTree(start, i - 1);
            List<TreeNode> rightTree = generateAllTree(i + 1, end);

            for (TreeNode leftNode : leftTree) {
                for (TreeNode rightNode : rightTree) {
                    TreeNode currNode = new TreeNode(i);
                    currNode.left = leftNode;
                    currNode.right = rightNode;
                    trees.add(currNode);
                }
            }
        }
        return trees;
    }
}
