package com.dynamicProgramming.TwoDimensionDP;

import java.util.Arrays;

public class MinimumFallingPathSum {

    /**
     * Recursion and memoization approach
     *
     * @param matrix
     * @return
     */
    public int minFallingPathSumRecursionMemoization(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int ans = Integer.MAX_VALUE;

        int[][] dp = new int[row][col];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        // Moving across columns
        for (int i = 0; i < col; i++) {
            ans = Math.min(ans, solveRecurMemo(row - 1, i, col, matrix, dp));
        }
        return ans;
    }

    private static int solveRecurMemo(int curRow, int curCol, int col, int[][] matrix, int[][] dp) {
        if (curCol < 0 || curCol >= col) {
            return (int) Math.pow(10, 9);
        }

        if (curRow == 0) {
            return matrix[0][curCol];
        }

        if (dp[curRow][curCol] != -1) {
            return dp[curRow][curCol];
        }

        int up = matrix[curRow][curCol] + solveRecurMemo(curRow - 1, curCol, col, matrix, dp);
        int leftDiagonal = matrix[curRow][curCol] + solveRecurMemo(curRow - 1, curCol - 1, col, matrix, dp);
        int rightDiagonal = matrix[curRow][curCol] + solveRecurMemo(curRow - 1, curCol + 1, col, matrix, dp);

        return dp[curRow][curCol] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
    }

    /**
     * Tabulation
     *
     * @param matrix
     * @return
     */
    public int minFallingPathSumTabulation(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row][col];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        // base case
        for (int j = 0; j < col; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int up = matrix[i][j] + dp[i - 1][j];

                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += dp[i - 1][j - 1];
                } else {
                    leftDiagonal += (int) Math.pow(10, 9);
                }

                int rightDiagonal = matrix[i][j];
                if (j + 1 < col) {
                    rightDiagonal += dp[i - 1][j + 1];
                } else {
                    rightDiagonal += (int) Math.pow(10, 9);
                }

                // Store the maximum of the three paths in dp
                dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
        }

        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            mini = Math.min(mini, dp[row - 1][i]);
        }
        return mini;
    }
}
