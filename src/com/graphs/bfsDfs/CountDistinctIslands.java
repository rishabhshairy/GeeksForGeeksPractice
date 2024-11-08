package com.graphs.bfsDfs;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * LC Premium Question
 * GFG --> https://www.geeksforgeeks.org/problems/number-of-distinct-islands/0
 */
public class CountDistinctIslands {

    static class Island {
        int row;
        int col;

        public Island(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}};

        System.out.println(new CountDistinctIslands().countDistinctIslands(grid));
    }

    /**
     * Using DFS here,
     * It can also be done using BFS similar to number of islands problem
     *
     * @param grid
     * @return
     */
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int rowSize = grid.length;
        int colSize = grid[0].length;

        boolean[][] visited = new boolean[rowSize][colSize];
        HashSet<ArrayList<String>> result = new HashSet<>();

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ArrayList<String> currIsland = new ArrayList<>();
                    // always carry base co-oridnates to find difference
                    dfs(i, j, visited, grid, currIsland, i, j);
                    result.add(currIsland);
                }
            }
        }

        return result.size();
    }

    private void dfs(int currRow, int currCol, boolean[][] visited, int[][] grid, ArrayList<String> currIsland, int baseRow, int baseCol) {
        visited[currRow][currCol] = true;
        currIsland.add(toString(currRow - baseRow, currCol - baseCol));
        int rowSize = grid.length;
        int colSize = grid[0].length;

        int[] deltaRow = {1, 0, -1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nextRow = currRow + deltaRow[i];
            int nextCol = currCol + deltaCol[i];

            if (nextRow >= 0 && nextRow < rowSize && nextCol >= 0 && nextCol < colSize
                    && !visited[nextRow][nextCol] && grid[nextRow][nextCol] == 1) {
                dfs(nextRow, nextCol, visited, grid, currIsland, baseRow, baseCol);

            }
        }

    }

    private String toString(int i, int i1) {
        return Integer.toString(i) + " " + Integer.toString(i1);
    }
}
