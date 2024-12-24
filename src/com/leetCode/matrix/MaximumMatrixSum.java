package com.leetCode.matrix;

/**
 * LC Daily Nov 24,24
 * <p>
 * You are given an n x n integer matrix. You can do the following operation any number of times:
 * <p>
 * Choose any two adjacent elements of matrix and multiply each of them by -1.
 * Two elements are considered adjacent if and only if they share a border.
 * <p>
 * Your goal is to maximize the summation of the matrix's elements.
 * Return the maximum sum of the matrix's elements using the operation mentioned above.
 */
public class MaximumMatrixSum {
    /**
     * Approach here is count of negatives in matrix
     * if negatives are even, ans is total absolute sum of matrix
     * if negatives are odd, ans is totalAbsoluteSum - ( 2 * min(mat))
     *
     * @param matrix
     * @return
     */
    public long maxMatrixSum(int[][] matrix) {
        long totalSum = 0;
        long mini = Integer.MAX_VALUE;
        int negatives = 0;

        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (matrix[i][j] < 0) {
                    negatives++;
                }
                totalSum += Math.abs(matrix[i][j]);
                mini = Math.min(Math.abs(matrix[i][j]), mini);
            }
        }

        // now if negatives are Odd reduce sum by twice of absolute min in entire matrix
        if ((negatives & 1) == 1) {
            totalSum -= 2 * mini;
        }
        return totalSum;
    }
}
