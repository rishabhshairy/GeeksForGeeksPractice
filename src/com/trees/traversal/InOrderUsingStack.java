package com.trees.traversal;

import com.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderUsingStack {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode node = root;
        while (true) {
            if (node != null) {
                nodeStack.push(node);
                node = node.left;
            } else {
                if (nodeStack.isEmpty()) {
                    break;
                }
                node = nodeStack.pop();
                inorderList.add(node.data);
                node = node.right;
            }
        }
        return inorderList;
    }
}
