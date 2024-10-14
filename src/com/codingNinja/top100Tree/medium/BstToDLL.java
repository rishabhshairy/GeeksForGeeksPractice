package com.codingNinja.top100Tree.medium;

import java.util.ArrayList;
import java.util.List;

public class BstToDLL {
    static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    /**
     * Optimal solution is using morris traversal
     *
     * @param root
     * @return
     */
    public static TreeNode<Integer> bstToSortedDLL(TreeNode<Integer> root) {
        // Write your code here.
        TreeNode<Integer> currNode = root;
        TreeNode<Integer> prev = null; // using for morris traversal
        TreeNode<Integer> newRoot = null;

        while (currNode != null) {


            if (currNode.left == null) {
                // store / print in case of in-order
                if (newRoot == null) {
                    newRoot = currNode;
                    prev = currNode;
                } else {
                    prev.right = currNode;
                    currNode.left = prev;
                }

                prev = currNode;
                currNode = currNode.right;
            } else {

                TreeNode<Integer> currPre = currNode.left;
                while (currPre.right != null && currPre.right != currNode) {
                    currPre = currPre.right;
                }

                if (currPre.right == null) {
                    currPre.right = currNode;
                    // store / print in case of pre-order
                    currNode = currNode.left;
                } else {
                    currNode = currPre.right;
                    prev.right = currNode;
                    currNode.left = prev;
                    prev = currNode;
                    currNode = currNode.right;
                }
            }
        }

        return newRoot;
    }

    /**
     * Trying out brute force
     *
     * @param root
     * @return
     */
    public static TreeNode<Integer> bstToSortedDLLBruteForce(TreeNode<Integer> root) {
        // Write your code here.
        if (root == null) {
            return null;
        }
        List<TreeNode<Integer>> inorderList = new ArrayList<>();
        findInorder(root, inorderList);
        TreeNode<Integer> newRoot = inorderList.get(0);

        TreeNode<Integer> temp = newRoot;
        for (int i = 1; i < inorderList.size(); i++) {
            temp.right = inorderList.get(i);
            inorderList.get(i).left = temp;
            temp = temp.right;
        }
        return newRoot;

    }

    private static void findInorder(TreeNode<Integer> node, List<TreeNode<Integer>> inorderList) {
        if (node == null) {
            return;
        }
        findInorder(node.left, inorderList);
        inorderList.add(node);
        findInorder(node.right, inorderList);
    }
}
