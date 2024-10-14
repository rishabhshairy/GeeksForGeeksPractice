package com.codingNinja.top100Tree.medium;

import com.leetCode.Trees.TreeNode;

public class SubTreeOfAnotherTree {
    public static boolean isSubtree(TreeNode T, TreeNode S) {
        // Write your code here.
        if (T == null && S == null) {
            return true;
        }
        if (T == null || S == null) {
            return false;
        }

        // check if root is same
        if (T.val == S.val) {
            if (isSubtree(T.left, S.left) && isSubtree(T.right, S.right)) {
                return true;
            }
        }

        return isSubtree(T.left, S) || isSubtree(T.right, S);
    }
}
