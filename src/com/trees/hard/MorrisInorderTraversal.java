package com.trees.hard;

import com.leetCode.Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * This technique uses O(1) space
 */
public class MorrisInorderTraversal {
    List<Integer> getInorder(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        TreeNode currNode = root;
        while (currNode != null) {

            // this case signifies that left subtree is null so only root is there
            if (currNode.left == null) {
                inorderList.add(currNode.val);
                currNode = currNode.right;
            } else {
                TreeNode prev = currNode.left;
                while (prev.right != null && prev.right != currNode) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = currNode; // creating a thread to currNode
                    // preOrderList.add(currNode.val)
                    currNode = currNode.left;
                } else {
                    prev.right = null;
                    inorderList.add(currNode.val);
                    currNode = currNode.right;
                }
            }
        }
        return inorderList;
    }
}
