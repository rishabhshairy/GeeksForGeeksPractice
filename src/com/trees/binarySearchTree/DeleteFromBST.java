package com.trees.binarySearchTree;

import com.trees.TreeNode;

public class DeleteFromBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            return deleteUtil(root);
        }

        // now if root is not to be deleted , then find and delete
        TreeNode temp = root;
        while (root != null) {
            if (root.val <= key) {
                if (root.right != null && root.right.val == key) {
                    root.right = deleteUtil(root.right);
                    break;
                } else {
                    root = root.right;
                }
            } else {
                if (root.left != null && root.left.val == key) {
                    root.left = deleteUtil(root.left);
                    break;
                } else {
                    root = root.left;
                }
            }
        }
        return temp;
    }

    /**
     * @param nodeToBeDeleted
     * @return
     */
    private TreeNode deleteUtil(TreeNode nodeToBeDeleted) {
        // check for empty left and right subtree
        if (nodeToBeDeleted.left == null) {
            return nodeToBeDeleted.right;
        } else if (nodeToBeDeleted.right == null) {
            return nodeToBeDeleted.left;
        }

        TreeNode rightNode = nodeToBeDeleted.right;
        TreeNode lastRightNode = findLastRightNode(nodeToBeDeleted.left);
        lastRightNode.right = rightNode;
        return nodeToBeDeleted.left;
    }

    private TreeNode findLastRightNode(TreeNode node) {
        if (node.right == null) {
            return node;
        }
        return findLastRightNode(node.right);
    }
}
