package com.trees.medium;

import com.trees.TreeNode;

public class IdenticalTrees {

    /**
     * Check any traversal and it should come same for both tree
     * here we will check for pre-order
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }

        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
