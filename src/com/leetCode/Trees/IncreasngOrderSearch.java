package com.leetCode.Trees;

public class IncreasngOrderSearch {
    TreeNode head;

    public TreeNode increasingBST(TreeNode root) {

        if (root == null) {
            return null;
        }
        TreeNode preCurr = new TreeNode(-1);
        head = preCurr;
        solve(root.left);
        return head.right;
    }

    private void solve(TreeNode root) {
        if (root == null) {
            return;
        }
        solve(root.left);

        TreeNode node = new TreeNode(root.val);
        head.right = node;
        head=head.right;

        solve(root.right);
    }

}
