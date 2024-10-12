package com.codingNinja.top100Tree;

public class SumLeftLeafNodes {
    static class TreeNode<T> {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static boolean leftMovement = true;

    public static int sumOfLeftLeaves(TreeNode<Integer> root) {
        // Write your code here.
        int[] sum = {0};
        solve(root, sum);
        return sum[0];
    }

    private static void solve(TreeNode<Integer> node, int[] sum) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null && leftMovement) {
            sum[0] += node.data;
        }
        leftMovement = true;
        solve(node.left, sum);
        leftMovement = false;
        solve(node.right, sum);
    }
}
