package com.dynamicProgramming.TwoDimensionDP;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class TriangleMinimumPathSum {
    public static void main(String[] args) {

    }

    /**
     * Recursion and Memoization approach
     *
     * @param triangle
     * @return
     */
    public int minimumTotalRecursionMemoization(List<List<Integer>> triangle) {
        int[][] grid = triangle.stream().map(x -> x.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new);
        int row = grid.length;

        int[][] dp = new int[row][row];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solveRecurMemo(0, 0, row, grid, dp);
    }

    private int solveRecurMemo(int currRow, int currCol, int row, int[][] grid, int[][] dp) {
        if (currRow == row - 1) {
            return grid[currRow][currCol];
        }

        if (dp[currRow][currCol] != -1) {
            return dp[currRow][currCol];
        }

        int down = grid[currRow][currCol] + solveRecurMemo(currRow + 1, currCol, row, grid, dp);
        int diagonal = grid[currRow][currCol] + solveRecurMemo(currRow + 1, currCol + 1, row, grid, dp);

        return dp[currRow][currCol] = Math.min(down, diagonal);
    }

    /**
     * Tabulation Approach
     *
     * @param triangle
     * @return
     */
    public int minimumTotalTabulation(List<List<Integer>> triangle) {
        int[][] grid = triangle.stream().map(x -> x.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new);
        int row = grid.length;

        int[][] dp = new int[row][row];
        // base case
        for (int j = 0; j < row; j++) {
            dp[row - 1][j] = grid[row - 1][j];
        }

        // filling tabulation
        for (int i = row - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = grid[i][j] + dp[i + 1][j];
                int diag = grid[i][j] + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, diag);
            }
        }

        return dp[0][0];
    }

    public int minimumTotalSpaceOptimised(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] frontDp = new int[n];
        int[] currDp = new int[n];
        for (int j = 0; j < n; j++) {
            frontDp[j] = triangle.get(n - 1).get(j);
        }

        for (int i = n - 2; i >= 0; i--) {

            for (int j = i; j >= 0; j--) {
                int down = triangle.get(i).get(j) + frontDp[j];
                int diag = triangle.get(i).get(j) + frontDp[j+1];
                currDp[j] = Math.min(down, diag);
            }
            frontDp = currDp.clone();
        }
        return frontDp[0];
    }
}
