package com.leetcode.Trees;

import java.util.ArrayList;

public class FlattenBTLinklist {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        ArrayList<TreeNode> nodes = new ArrayList<>();
        traversePreOrder(root, nodes);
        root = nodes.get(0);
        TreeNode temp=root;
        for (int i = 1; i < nodes.size(); i++) {
            temp.right = nodes.get(i);
            temp.left=null;
            temp=temp.right;
        }
    }

    private void traversePreOrder(TreeNode root, ArrayList<TreeNode> nodes) {
        if (root == null) {
            return;
        }
        nodes.add(root);
        traversePreOrder(root.left, nodes);
        traversePreOrder(root.right, nodes);
    }
}
