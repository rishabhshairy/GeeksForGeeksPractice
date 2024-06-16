package com.leetCode.Trees;

import java.util.HashMap;

public class ConstructBinaryTreefromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // array to use for pre-indexes
        int[] current = {0};
        HashMap<Integer, Integer> inorderHashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderHashMap.put(inorder[i], i);
        }
        return construct(0, preorder.length - 1, preorder, current, inorderHashMap);
    }

    private TreeNode construct(int start, int end, int[] preorder, int[] current, HashMap<Integer, Integer> inorderHashMap) {
        if (current[0] >= preorder.length) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[current[0]]);
        if (start > end) {
            return null;
        }
        else {
            current[0]++;
            int index = inorderHashMap.get(root.val);

            root.left = construct(start, index - 1, preorder, current, inorderHashMap);
            root.right = construct(index + 1, end, preorder, current, inorderHashMap);
        }


        return root;
    }
}
