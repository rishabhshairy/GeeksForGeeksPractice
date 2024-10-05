package com.trees.hard;

import com.trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPostAndInorder {
    /**
     * Take root from last of postorder
     * hash inorder tree
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder==null || postorder == null || inorder.length!=postorder.length){
            return null;
        }

        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        TreeNode node = buildFromPostIn(postorder, 0, postorder.length - 1,
                inorder, 0, inorder.length - 1, inorderMap);
        return node;
    }

    private static TreeNode buildFromPostIn(int[] postorder, int postStart, int postEnd,
                                     int[] inorder, int inStart, int inEnd,
                                     Map<Integer, Integer> inorderMap) {


        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        TreeNode rootNode = new TreeNode(postorder[postEnd]);
        int inorderRootIndex = inorderMap.get(postorder[postEnd]);
        int nodesLeft = inorderRootIndex - inStart;

        rootNode.left = buildFromPostIn(postorder, postStart, postStart + nodesLeft - 1,
                            inorder, inStart, inorderRootIndex - 1, inorderMap);

        rootNode.right = buildFromPostIn(postorder, postStart + nodesLeft, postEnd - 1,
                            inorder, inorderRootIndex + 1, inEnd, inorderMap);

        return rootNode;
    }
}
