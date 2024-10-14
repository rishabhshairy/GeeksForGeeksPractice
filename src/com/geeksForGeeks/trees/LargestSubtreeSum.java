package com.geeksForGeeks.trees;

import java.util.Map;

public class LargestSubtreeSum {
    public static int findLargestSubtreeSum(Node root) {
        // code here
        int[] maxi = {Integer.MIN_VALUE};
        solve(root, maxi);
        return maxi[0];
    }

    private static int solve(Node node, int[] maxi) {
        if (node == null) {
            return 0;
        }

        int currSum = node.data + solve(node.left, maxi) + solve(node.right, maxi);

        maxi[0] = Math.max(currSum, maxi[0]);

        return currSum;
    }
}
