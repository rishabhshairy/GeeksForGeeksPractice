package com.trees.binarySearchTree;

import com.trees.TreeNode;

public class LCAofBST {

    /**
     * Optimal solution
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        int currVal = root.val;
        if (currVal < p.val && currVal < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (currVal > p.val && currVal > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    /**
     * Similar code to BT
     * TC --> O(n)
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorBruteForce(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestorBruteForce(root.left, p, q);
        TreeNode right = lowestCommonAncestorBruteForce(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}
