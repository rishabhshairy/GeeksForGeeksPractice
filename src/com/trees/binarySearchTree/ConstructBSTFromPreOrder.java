package com.trees.binarySearchTree;

import com.trees.TreeNode;

public class ConstructBSTFromPreOrder {
    /**
     * 1. Brute force
     * Sort the pre-order it will render in-order array
     * then use inorder and pre-order to create binary tree which will be unique
     * tc --> O(nlogN) + O(N)
     * sc --> O(n)
     */

    /**
     * This is optimal solution, where we are using bound concept
     * for each node there will be a bound max and min
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] len = {0}; // this will contain index of node
        return formTree(preorder, Integer.MAX_VALUE, len);
    }

    private TreeNode formTree(int[] preorder, int bound, int[] len) {
        if (len[0] == preorder.length || preorder[len[0]] > bound) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[len[0]++]);
        root.left = formTree(preorder, root.val, len);
        root.right = formTree(preorder, bound, len);
        return root;
    }
}
