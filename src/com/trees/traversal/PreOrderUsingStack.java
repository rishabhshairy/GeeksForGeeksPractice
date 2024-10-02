package com.trees.traversal;

import com.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderUsingStack {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrderList = new ArrayList<>();
        if (root == null) {
            return preOrderList;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            root = nodeStack.pop();
            preOrderList.add(root.val);
            if (root.right != null) {
                nodeStack.push(root.right);
            }
            if (root.left != null) {
                nodeStack.push(root.left);
            }
        }
        return preOrderList;
    }
}
