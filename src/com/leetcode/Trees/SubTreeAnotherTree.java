package com.leetcode.Trees;

public class SubTreeAnotherTree {
//    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
////        TLE Solution Naive Approach
///*        if (root == null || subRoot == null) {
//            return false;
//        }
//        StringBuilder bigTree = new StringBuilder();
//        TreeNode temp=findSubRoot(root,subRoot);
//        inorder(temp, bigTree);
//        StringBuilder subTree = new StringBuilder();
//        inorder(subRoot, subTree);
//        if (bigTree.equals(subTree)){
//            return true;
//        }
//        return false;
//    }
//
//    private void inorder(TreeNode root, StringBuilder tree) {
//        if (root == null) {
//            return;
//        }
//        inorder(root.left, tree);
//        tree.append(root.val);
//        inorder(root.right, tree);
//    }
//
//    private TreeNode findSubRoot(TreeNode root, TreeNode subRoot) {
//        while (root != null) {
//            if (root.val == subRoot.val) {
//                return root;
//            }
//            if (root.left != null) {
//                root = root.left;
//            }
//            if (root.right != null) {
//                root = root.right;
//                ;
//            }
//        }
//        return null;
//    }*/

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (isEqual(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isEqual(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }

        if (root.val != subRoot.val) {
            return false;
        }

        return isEqual(root.left, subRoot.left) && isEqual(root.right, subRoot.right);
    }
}
