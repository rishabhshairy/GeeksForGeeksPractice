package com.codingNinja.top100Tree;

public class BreakTree {
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

    static int mod = (int) 1e9;
    static long sum = 0;
    static long ans = 0;

    public static int maxProduct(TreeNode<Integer> root) {
        //    Write your code here.

        findSum(root);
        findMaxProduct(root);
        return (int) (ans % mod);
    }

    private static int findMaxProduct(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int left = findMaxProduct(root.left);
        int right = findMaxProduct(root.right);

        int curr = left + right + root.data;

        ans = Math.max(ans, Math.max((sum - left) * left, (sum - right) * right));

        return curr;
    }

    private static void findSum(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        sum += root.data;
        findSum(root.left);
        findSum(root.right);
    }
}
