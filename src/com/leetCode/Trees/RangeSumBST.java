package com.leetCode.Trees;

import java.util.ArrayList;

public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        ArrayList<Integer> nums = new ArrayList<>();
        int sum = 0;
        solve(root, low, high, nums);
        for (Integer num :
                nums) {
            sum += num;
        }
        return sum;
    }

    private void solve(TreeNode root, int low, int high, ArrayList<Integer> nums) {
        if (root.left == null && root.right == null) {
            if (root.val >= low && root.val <= high) {
                nums.add(root.val);
            }
            return;
        }
        if (root.left != null) {
            solve(root.left, low, high, nums);
        }
        if (root.right!=null){
            solve(root.right, low, high, nums);
        }

    }
}
