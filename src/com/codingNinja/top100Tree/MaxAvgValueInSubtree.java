package com.codingNinja.top100Tree;

public class MaxAvgValueInSubtree {
    static class TreeNode<T> {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = right = null;
        }

    }

    public static double maxSubtreeAverage(TreeNode<Integer> root) {
        // Write your code here.
        double[] result = {0}; // to store count and max avg
        findMaxAvg(root, result);
        return result[0];
    }

    private static double[] findMaxAvg(TreeNode<Integer> root, double[] result) {
        if (root == null) {
            return new double[] {-1,0};
        }

        double[] left = findMaxAvg(root.left, result);
        double[] right = findMaxAvg(root.right, result);
        double sum = root.data + left[0] + right[0];
        double nodes = 1 + left[1] + right[1];
        result[0] = Math.max(result[0], sum / nodes);
        return new double[]{sum, nodes};
    }
}
