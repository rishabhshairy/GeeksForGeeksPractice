package com.leetCode.Trees.med;

import com.leetCode.Trees.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class FindElements {
    Set<Integer> treeValSet;

    public FindElements(TreeNode root) {
        treeValSet = new HashSet<>();
        if (root != null && root.val == -1) {
            root.val = 0;
            treeValSet.add(0);
        }

        recover(root);
        System.out.println(treeValSet);
    }

    private void recover(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            node.left.val = 2 * node.val + 1;
            treeValSet.add(node.left.val);
        }
        if (node.right != null) {
            node.right.val = 2 * node.val + 2;
            treeValSet.add(node.right.val);
        }
        recover(node.left);
        recover(node.right);
    }

    public boolean find(int target) {
        return treeValSet.contains(target);
    }
}
