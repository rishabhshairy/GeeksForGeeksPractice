package com.dynamicProgramming.TwoDimensionDP;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/unique-paths-ii/description/
 */
public class UniquePathWithObstacles {
    public static void main(String[] args) {

    }

    /**
     * Recursive Solution
     *
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row + 1][col + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return findPathRecursionMemo(row - 1, col - 1, obstacleGrid, dp);
    }

    /**
     * Both recursive and memoization solution
     *
     * @param row
     * @param col
     * @param obstacleGrid
     * @param dp
     * @return
     */
    private static int findPathRecursionMemo(int row, int col, int[][] obstacleGrid, int[][] dp) {
        if (row >= 0 && col >= 0 && obstacleGrid[row][col] == -1) {
            return 0;
        }
        if (row < 0 || col < 0) {
            return 0;
        }
        if (row == 0 && col == 0) {
            return 1;
        }

        // memoize with dp array
        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int up = findPathRecursionMemo(row - 1, col, obstacleGrid, dp);
        int left = findPathRecursionMemo(row, col - 1, obstacleGrid, dp);

        return dp[row][col] = up + left;

    }

    public static int uniquePathsWithObstaclesTabulation(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == -1) {
                    dp[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    int up = i > 0 ? dp[i - 1][j] : 0;
                    int left = j > 0 ? dp[i][j - 1] : 0;
                    dp[i][j] = (up + left);
                }
            }
        }
        return dp[row - 1][col - 1];
    }

}
