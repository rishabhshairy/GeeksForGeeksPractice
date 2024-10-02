package com.trees.traversal;

import com.trees.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostOrderUsing2Stacks {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrderList = new ArrayList<>();
        if (root == null) {
            return postOrderList;
        }

        Stack<TreeNode> opStack = new Stack<>();
        opStack.push(root);

        while (!opStack.isEmpty()) {
            root = opStack.pop();
            if (root.left != null) {
                opStack.push(root.left);
            }

            if (root.right != null) {
                opStack.push(root.right);
            }
            postOrderList.add(root.val);
        }
        Collections.reverse(postOrderList);
        return postOrderList;
    }
}
