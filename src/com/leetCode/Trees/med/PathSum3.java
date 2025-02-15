package com.leetCode.Trees.med;

import com.trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSum3 {

    /**
     * Optimal using map
     *
     * @param root
     * @param targetSum
     * @return
     */

    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        final Map<Long, Integer> sumCount = new HashMap<>();
        solve(root, targetSum, 0, sumCount);
        return count;
    }

    private void solve(TreeNode node, int targetSum, long currSum, Map<Long, Integer> sumCount) {
        if (node == null) {
            return;
        }
        currSum += node.val;
        if (targetSum == currSum) {
            count++;
        }

        count += sumCount.getOrDefault(currSum - targetSum, 0);
        sumCount.put(currSum, sumCount.getOrDefault(currSum, 0) + 1);
        solve(node.left, targetSum, currSum, sumCount);
        solve(node.right, targetSum, currSum, sumCount);

        sumCount.put(currSum, sumCount.get(currSum) - 1);
    }


    /**
     * This approach is brute force
     *
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSumBruteForce(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        return pathSumBruteForce(root.left, targetSum) + pathSumBruteForce(root.right, targetSum) + pathSumFromRoot(root, targetSum);
    }

    private int pathSumFromRoot(TreeNode node, long targetSum) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (node.val == targetSum) {
            count = 1;
        }
        count += pathSumFromRoot(node.left, targetSum - node.val);
        count += pathSumFromRoot(node.right, targetSum - node.val);
        return count;
    }
}
