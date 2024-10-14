package com.codingNinja.top100Tree.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * LC Premium
 * Company asked
 */
public class SplitBST {
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

    public static ArrayList<TreeNode<Integer>> splitBST(TreeNode<Integer> root, int val) {
        //    Write your code here
        ArrayList<TreeNode<Integer>> result = new ArrayList<>();
        TreeNode<Integer>[] ans = findSplit(root, val);
        result.add(ans[0]);
        result.add(ans[1]);

        return result;
    }

    private static TreeNode<Integer>[] findSplit(TreeNode<Integer> node, int val) {
        if (node == null) {
            TreeNode<Integer>[] ans = (TreeNode<Integer>[]) Array.newInstance(TreeNode.class, 2);
            ans[0] = null;
            ans[1] = null;
            return ans;
        }

        if (node.data <= val) {
            TreeNode<Integer>[] ans = findSplit(node.right, val);
            node.right = ans[0];
            ans[0] = node;
            return ans;
        } else {
            TreeNode<Integer>[] ans = findSplit(node.left, val);
            node.left = ans[1];
            ans[1] = node;
            return ans;
        }
    }
}
