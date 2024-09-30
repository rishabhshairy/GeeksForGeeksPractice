package com.trees.traversal;

import com.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllTraversalUsingRecursion {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        // Write your code here.
        List<List<Integer>> result = new ArrayList<>();
        result.add(inorder(root));
        result.add(preorder(root));
        result.add(postorder(root));
        return result;
    }

    private static List<Integer> postorder(TreeNode root) {
        List<Integer> postOrderList = new ArrayList<>();
        traversePostOrder(root, postOrderList);
        return postOrderList;
    }

    private static void traversePostOrder(TreeNode root, List<Integer> postOrderList) {
        if (root == null)
            return;

        traversePostOrder(root.left, postOrderList);
        traversePostOrder(root.right, postOrderList);
        postOrderList.add(root.data);
    }

    private static List<Integer> preorder(TreeNode root) {
        List<Integer> preOrderList = new ArrayList<>();
        traversePreOrder(root, preOrderList);
        return preOrderList;
    }

    private static void traversePreOrder(TreeNode root, List<Integer> preOrderList) {

        if (root == null) {
            return;
        }

        preOrderList.add(root.data);
        traversePreOrder(root.left, preOrderList);
        traversePreOrder(root.right, preOrderList);
    }

    private static List<Integer> inorder(TreeNode root) {
        // Create empty array to store variables
        List<Integer> inorderList = new ArrayList<>();
        traverseInorder(root, inorderList);
        return inorderList;
    }

    private static void traverseInorder(TreeNode root, List<Integer> inorderList) {
        // base case --> when we reach the end of node
        if (root == null) {
            return;
        }

        // recurse on left subtree
        traverseInorder(root.left, inorderList);

        // push current node to list
        inorderList.add(root.data);

        // recursively travel right sub tree

        traverseInorder(root.right, inorderList);
    }
}
