package com.codingNinja.top100Tree.hard;

public class NinjaAndTreeRecovery {
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

    static TreeNode<Integer> prev = null;
    static TreeNode<Integer> first = null;
    static TreeNode<Integer> middle = null;
    static TreeNode<Integer> last = null;

    public static void recoverTree(TreeNode<Integer> root) {
        // Write your code here.
        first = middle = last = null;
        prev = new TreeNode<>(Integer.MIN_VALUE);
        findViolatedNodes(root);

        if (first != null && last != null) {
            swapVals(first, last);
        } else if (first != null && middle != null) {
            swapVals(first, middle);
        }
    }

    /**
     * Do in-order traversal
     *
     * @param root
     */
    private static void findViolatedNodes(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        findViolatedNodes(root.left);

        if (prev != null && root.data < prev.data) {
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }

        }
        prev = root;
        findViolatedNodes(root.right);
    }

    private static void swapVals(TreeNode<Integer> first, TreeNode<Integer> last) {
        int temp = first.data;
        first.data = last.data;
        last.data = temp;
    }

}
