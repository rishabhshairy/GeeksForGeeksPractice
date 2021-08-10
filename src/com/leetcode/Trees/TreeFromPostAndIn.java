package com.leetcode.Trees;

import java.util.HashMap;
import java.util.Map;

public class TreeFromPostAndIn {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] current = {postorder.length - 1};
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return construct(0, postorder.length - 1, postorder, current, inorderMap);
    }

    private TreeNode construct(int start, int end, int[] postorder, int[] current, Map<Integer, Integer> inorderMap) {
        if (current[0] < 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[current[0]]);
        current[0]--;
        if (start > end) {
            return null;
        } else {
            int index = inorderMap.get(root.val);
            root.right = construct(start, index - 1, postorder, current, inorderMap);
            root.left = construct(index + 1, end, postorder, current, inorderMap);
        }

        return root;
    }

}
