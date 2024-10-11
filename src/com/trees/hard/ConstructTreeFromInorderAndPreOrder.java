package com.trees.hard;

import com.trees.TreeNode;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ConstructTreeFromInorderAndPreOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderMap = new LinkedHashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // initiate root of new Tree
        TreeNode root = build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
        return root;
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> inorderMap) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode rootNode = new TreeNode(preorder[preStart]);
        // get inorder root position which is 1st element of pre-order
        int inorderRootPosition = inorderMap.get(rootNode.val);
        int nodesLeft = inorderRootPosition - inStart;

        rootNode.left = build(preorder, preStart + 1, preStart + nodesLeft,
                inorder, inStart, inorderRootPosition - 1, inorderMap);

        rootNode.right = build(preorder, preStart + nodesLeft + 1, preEnd,
                inorder, inorderRootPosition + 1, inEnd, inorderMap);

        return rootNode;
    }
}
