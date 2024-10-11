package com.codingNinja.top100Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * VVIMP
 */
public class GreaterSumTree {
    static class TreeNode<T> {
        T val;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    /**
     * Optimal approach
     * Reverse in-order
     */
    private static int sum;

    public static TreeNode<Integer> convertBstToGreaterSum(TreeNode<Integer> root) {
        // Write your code here.
        if (root == null) {
            return null;
        }
        sum = 0;
        reverseInorder(root);
        return root;
    }

    private static void reverseInorder(TreeNode<Integer> node) {
        if (node == null) {
            return;
        }
        reverseInorder(node.right);
        int temp = node.val;
        node.val = sum;
        sum += temp;

        reverseInorder(node.left);
    }

    /**
     * Brute force approach
     * use inorder traversal and sum in map
     * re-assign  the values using map
     *
     * @param root
     * @return
     */
    public static TreeNode<Integer> convertBstToGreaterSumBF(TreeNode<Integer> root) {
        // Write your code here.
        ArrayList<Integer> inorderList = new ArrayList<>();
        findInorder(root, inorderList);
        Map<Integer, Integer> sumMap = new HashMap<>();

        for (int i = 0; i < inorderList.size(); i++) {
            int sum = 0;
            for (int j = i + 1; j < inorderList.size(); j++) {
                sum += inorderList.get(j);
            }
            sumMap.put(inorderList.get(i), sum);
        }

        swapValuesInTree(root, sumMap);

        return root;
    }

    private static void swapValuesInTree(TreeNode<Integer> node, Map<Integer, Integer> sumMap) {
        if (node == null) {
            return;
        }
        swapValuesInTree(node.left, sumMap);
        if (sumMap.containsKey(node.val)) {
            node.val = sumMap.get(node.val);
        }
        swapValuesInTree(node.right, sumMap);
    }

    private static void findInorder(TreeNode<Integer> node, ArrayList<Integer> inorderList) {
        if (node == null) {
            return;
        }
        findInorder(node.left, inorderList);
        inorderList.add(node.val);
        findInorder(node.right, inorderList);
    }
}
