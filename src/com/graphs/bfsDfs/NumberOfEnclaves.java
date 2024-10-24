package com.graphs.bfsDfs;

/**
 * Multi-source Flood Fill Algo
 */
public class NumberOfEnclaves {
    public int numEnclaves(int[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;

        boolean[][] visited = new boolean[rowSize][colSize];
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};
        // visit all boundaries

        // visiting first row and last row

        for (int col = 0; col < colSize; col++) {

            // first row
            if (!visited[0][col] && grid[0][col] == 1) {
                dfs(0, col, visited, grid, deltaRow, deltaCol);
            }

            // last row
            if (!visited[rowSize - 1][col] && grid[rowSize - 1][col] == 1) {
                dfs(rowSize - 1, col, visited, grid, deltaRow, deltaCol);
            }
        }

        // visiting first column and last column
        for (int row = 0; row < rowSize; row++) {

            // first column
            if (!visited[row][0] && grid[row][0] == 1) {
                dfs(row, 0, visited, grid, deltaRow, deltaCol);
            }

            // last column
            if (!visited[row][colSize - 1] && grid[row][colSize - 1] == 1) {
                dfs(row, colSize - 1, visited, grid, deltaRow, deltaCol);
            }
        }

        // now count remaining lands
        int count = 0;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int row, int col, boolean[][] visited, int[][] grid, int[] deltaRow, int[] deltaCol) {
        visited[row][col] = true;
        int rowSize = grid.length;
        int colSize = grid[0].length;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + deltaRow[i];
            int nextCol = col + deltaCol[i];

            if (nextRow >= 0 && nextRow < rowSize && nextCol >= 0 && nextCol < colSize
                    && !visited[nextRow][nextCol] && grid[nextRow][nextCol] == 1) {
                dfs(nextRow, nextCol, visited, grid, deltaRow, deltaCol);

            }
        }
    }
}
