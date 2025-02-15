package com.leetCode.bfs_dfs;

public class CountServerCommunication {

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        CountServerCommunication obj = new CountServerCommunication();
        obj.countServers(grid);
    }

    int count = 0;

    public int countServers(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rowCount = grid.length;
        int colCount = grid[0].length;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 1) {
                    int server = dfs(i, j, rowCount, colCount, grid);
                    count += server == 1 ? 0 : server;

                }
            }
        }
        System.out.println(count);
        return count;
    }

    private int dfs(int row, int col, int rowCount, int colCount, int[][] grid) {
        // mark the server as 0 so other server dont count it
        grid[row][col] = 0;
        int res = 1;
        // traverse row and column separately
        for (int i = 0; i < rowCount; i++) {
            if (grid[i][col] == 1) {
                res += dfs(i, col, rowCount, colCount, grid);

            }
        }

        for (int j = 0; j < colCount; j++) {
            if (grid[row][j] == 1) {
                res += dfs(row, j, rowCount, colCount, grid);
            }
        }

        return res;
    }
}
