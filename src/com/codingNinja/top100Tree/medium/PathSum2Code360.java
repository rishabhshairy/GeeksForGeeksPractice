package com.codingNinja.top100Tree.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class PathSum2Code360 {
    static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static ArrayList<ArrayList<Integer>> KSumPaths(TreeNode<Integer> root, int k) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        int sum = 0;
        findAllPathFromRoot(root, k, sum, result, new ArrayList<Integer>());
        return result;
    }

    private static void findAllPathFromRoot(TreeNode<Integer> node, int k, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path) {
        if (node == null) {
            return;
        }
        sum += node.data;
        path.add(node.data);
        if (sum == k && node.left == null && node.right == null) {
            result.add(new ArrayList<>(path));

        }
        if (node.left != null) {
            findAllPathFromRoot(node.left, k, sum, result, path);
            path.remove(path.size() - 1);
        }

        if (node.right != null) {
            findAllPathFromRoot(node.right, k, sum, result, path);
            path.remove(path.size() - 1);
        }
    }
}
