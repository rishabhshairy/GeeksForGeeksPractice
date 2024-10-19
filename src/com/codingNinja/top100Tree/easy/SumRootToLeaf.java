package com.codingNinja.top100Tree.easy;

import com.codingNinja.top100Tree.BinaryTreeNode;

public class SumRootToLeaf {
    public static int rootToLeafSum(BinaryTreeNode<Integer> root) {
        // Write your code here.
        int mod = (int) (1e9 + 7);
        return (int) findSumToLeaf(root, mod, 0);
    }

    private static long findSumToLeaf(BinaryTreeNode<Integer> node, int mod, long currSum) {
        if (node == null) {
            return 0;
        }
        currSum = (currSum * 10 + node.data) % mod;
        if (node.left == null && node.right == null) {
            System.out.println(currSum);
            return currSum;
        }

        long leftSum = findSumToLeaf(node.left, mod, currSum);
        long rightSum = findSumToLeaf(node.right, mod, currSum);

        return (leftSum % mod + rightSum % mod) % mod;
    }


}
