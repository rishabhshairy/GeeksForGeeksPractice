package com.leetCode.arrays.prefixSum;

public class GridGame {

    public static void main(String[] args) {
        int[][] grid = {{2, 5, 4}, {1, 5, 1}};
        gridGame(grid);
    }

    public static long gridGame(int[][] grid) {
        int prefixSumRow1 = 0;
        int prefixSumRow2 = 0;
        long mini = Long.MAX_VALUE;

        for (int i = 0; i < grid[0].length; i++) {
            prefixSumRow1 += grid[0][i];
        }

        for (int currCol = 0; currCol < grid[0].length; currCol++) {
            prefixSumRow1 -= grid[0][currCol];
            mini = Math.min(mini, Math.max(prefixSumRow1, prefixSumRow2));
            prefixSumRow2 += grid[1][currCol];
        }
        return mini;
    }
}
