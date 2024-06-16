package com.leetCode.Trees;

import java.util.HashMap;

public class ConstructFromPostPre {
    int index = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            hm.put(postorder[i], i);
        }
        return solve(preorder, postorder, hm, 0, postorder.length - 1);
    }

    private TreeNode solve(int[] preorder, int[] postorder, HashMap<Integer, Integer> hm, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index++]);
        if (start == end) {
            return root;
        }
        int splitIndex = hm.get(preorder[index]);
        root.left = solve(preorder, postorder, hm, start, splitIndex);
        root.right = solve(preorder, postorder, hm, splitIndex + 1, end - 1);
        return root;
    }
}
