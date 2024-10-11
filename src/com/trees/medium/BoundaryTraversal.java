package com.trees.medium;

import com.trees.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BoundaryTraversal {
    public static List<Integer> traverseBoundary(TreeNode root) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();
        if (!isLeafNode(root)){
            result.add(root.val);
        }
        traverseLeftNodes(root, result);
        traverseLeafNodes(root, result);
        traverseRightNodes(root, result);
        return result;
    }

    private static void traverseRightNodes(TreeNode node, List<Integer> result) {
        TreeNode curr = node.right;
        List<Integer> clockWiseList = new ArrayList<>();
        while (curr != null) {
            if (!isLeafNode(curr)) {
                clockWiseList.add(curr.val);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        Collections.reverse(clockWiseList);
        result.addAll(clockWiseList);
    }

    // doing pre-order to get all leaf nodes
    private static void traverseLeafNodes(TreeNode root, List<Integer> result) {
        TreeNode curr = root;
        if (isLeafNode(curr)) {
            result.add(curr.val);
            return;
        }
        if (curr.left != null) {
            traverseLeafNodes(root.left, result);
        }
        if (curr.right != null) {
            traverseLeafNodes(root.right, result);
        }
    }

    private static void traverseLeftNodes(TreeNode node, List<Integer> result) {
        TreeNode curr = node.left;
        while (curr != null) {
            if (!isLeafNode(curr)) {
                result.add(curr.val);
            }
            // if left is null move to right
            if (curr.left == null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
    }

    private static boolean isLeafNode(TreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }
}
