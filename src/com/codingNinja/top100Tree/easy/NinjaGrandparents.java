package com.codingNinja.top100Tree.easy;

import com.trees.TreeNode;

public class NinjaGrandparents {
    static class TreeNode<T> {
        public T val;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public static int ninjaGrandparents(TreeNode<Integer> root) {
        //    Write your code here
        int[] sum = {0};
        solve(root, sum);
        return sum[0];
    }

    private static void solve(TreeNode<Integer> node, int[] sum) {
        if (node == null) {
            return;
        }
        if (node.val % 2 == 0) {
            // check for left grandchild
            if (node.left != null) {
                if (node.left.left != null) {
                    sum[0] += node.left.left.val;
                }
                if (node.left.right != null) {
                    sum[0] += node.left.right.val;
                }
            }
            // check for right grand child
            if (node.right != null) {
                if (node.right.left != null) {
                    sum[0] += node.right.left.val;
                }
                if (node.right.right != null) {
                    sum[0] += node.right.right.val;
                }
            }
        }

        solve(node.left, sum);
        solve(node.right, sum);
    }
}
