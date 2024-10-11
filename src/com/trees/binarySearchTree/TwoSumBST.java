package com.trees.binarySearchTree;

import com.trees.TreeNode;

import java.util.ArrayList;

public class TwoSumBST {


    public boolean findTargetBruteForce(TreeNode root, int k) {
        ArrayList<Integer> inorderList = new ArrayList<>();
        findInorder(root, inorderList);

        int left = 0;
        int right = inorderList.size() - 1;

        int[][] hash = new int[inorderList.size()][2];
        for (int i = 0; i < hash.length; i++) {
            hash[i][0] = i;
            hash[i][1] = inorderList.get(i);
        }

        while (left < right) {
            int sum = hash[left][1] + hash[right][1];

            if (sum < k) {
                left++;
            } else if (sum > k) {
                right--;
            } else if (sum == k) {
                return true;
            }
        }
        return false;
    }

    private void findInorder(TreeNode node, ArrayList<Integer> inorderList) {
        if (node == null) {
            return;
        }
        findInorder(node.left, inorderList);
        inorderList.add(node.val);
        findInorder(node.right, inorderList);
    }
}
