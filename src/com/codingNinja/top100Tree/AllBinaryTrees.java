package com.codingNinja.top100Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * this is a hard question which involves DP
 */
public class AllBinaryTrees {
    private static HashMap<Integer, ArrayList<BinaryTreeNode<Integer>>> dp = new LinkedHashMap<>();

    public static ArrayList<BinaryTreeNode<Integer>> findAllTrees(int n) {
        // Write your code here.
        if (n % 2 == 0) {
            return new ArrayList<>();
        }

        if (n == 1) {
            ArrayList<BinaryTreeNode<Integer>> singleNode = new ArrayList<>();
            singleNode.add(new BinaryTreeNode<>(0));
            return singleNode;
        }

        if (dp.containsKey(n)) {
            return dp.get(n);
        }

        ArrayList<BinaryTreeNode<Integer>> trees = new ArrayList<>();
        // now find the left and right subtree
        for (int i = 0; i < n; i++) {
            ArrayList<BinaryTreeNode<Integer>> leftTree = findAllTrees(i);
            ArrayList<BinaryTreeNode<Integer>> rightTree = findAllTrees(n - i - 1);

            for (BinaryTreeNode<Integer> left :
                    leftTree) {
                for (BinaryTreeNode<Integer> right :
                        rightTree) {
                    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(0);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }
        dp.put(n, trees);
        return trees;
    }
}
