package com.dynamicProgramming.TwoDimensionDP;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-path-sum/description/
 */
public class MinimumPathSum {
    public static void main(String[] args) {

    }

    /**
     * recursive and memoization
     *
     * @param grid
     * @return
     */
    public int minPathSumRecursiveMemoization(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        //return solveRecurrence(row - 1, col - 1, grid);

        // memoization approach
        int[][] dp = new int[row][col];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solveRecurrenceAndMemoization(row - 1, col - 1, grid, dp);
    }

    private int solveRecurrenceAndMemoization(int row, int col, int[][] grid, int[][] dp) {
        if (row == 0 && col == 0) {
            return grid[0][0];
        }
        if (row < 0 || col < 0) {
            return (int) Math.pow(10, 9);
        }

        // check dp array
        if (dp[row][col] != -1) {
            return dp[row][col];
        }


        int up = grid[row][col] + solveRecurrenceAndMemoization(row - 1, col, grid, dp);
        int left = grid[row][col] + solveRecurrenceAndMemoization(row, col - 1, grid, dp);

        return dp[row][col] = Math.min(up, left);
    }

    /**
     * Tabulation --> Bottom Up
     *
     * @param grid
     * @return
     */
    public int minPathSumTabulation(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] dp = new int[row][col];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {

                    int up = grid[i][j];
                    if (i > 0) {
                        up += dp[i - 1][j];
                    } else {
                        up += (int) Math.pow(10, 9); // Adding very large values when index out of bounds
                    }

                    int left = grid[i][j];
                    if (j > 0) {
                        left += dp[i][j - 1];
                    } else {
                        left += (int) Math.pow(10, 9);
                    }

                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        return dp[row - 1][col - 1];
    }
}
