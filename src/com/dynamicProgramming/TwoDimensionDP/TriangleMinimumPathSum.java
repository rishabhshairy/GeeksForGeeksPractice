package com.dynamicProgramming.TwoDimensionDP;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class TriangleMinimumPathSum {
    public static void main(String[] args) {

    }

    public int minimumTotal(List<List<Integer>> triangle) {
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
}
