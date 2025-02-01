package com.leetCode.bfs_dfs;

public class MaxFishInGrid {
    int[] deltaRow = {-1, 0, 1, 0};
    int[] deltaCol = {0, 1, 0, -1};

    public int findMaxFish(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int maxFish = Integer.MIN_VALUE;

        int[][] visited = new int[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                int fishCount = 0;
                if (grid[i][j] > 0 && visited[i][j] != 1) {
                    fishCount += dfs(i, j, grid, visited);
                }
                maxFish = Math.max(fishCount, maxFish);
            }
        }
        return maxFish;
    }

    private int dfs(int row, int col, int[][] grid, int[][] visited) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        visited[row][col] = 1;
        int fish = grid[row][col];

        for (int i = 0; i < 4; i++) {
            int nextRow = row + deltaRow[i];
            int nextCol = col + deltaCol[i];

            if (nextRow >= 0 && nextCol >= 0 && nextRow < rowCount && nextCol < colCount
                    && grid[nextRow][nextCol] > 0 && visited[nextRow][nextCol] != 1) {
                fish += dfs(nextRow, nextCol, grid, visited);
            }

        }
        return fish;
    }
}
