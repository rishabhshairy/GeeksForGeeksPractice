package com.leetCode.graphs.unionFind;

import java.util.*;

public class NumberOfClosedIslands {
    public static void main(String[] args) {
//        int[][] grid = {{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0},
//                {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}};
        int[][] grid = {{0, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {0, 1, 1, 1, 0}};
        NumberOfClosedIslands obj = new NumberOfClosedIslands();
        obj.closedIsland(grid);
    }

    /**
     * Approach
     * Number all the components with node
     *
     * @param grid
     * @return
     */
    public int closedIsland(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        boolean[][] visited = new boolean[rowCount][colCount];
        int count = 0;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 0 && !visited[i][j] && bfs(i, j, rowCount, colCount, grid, visited)) {
                    count++;
                }
            }
        }

        System.out.print(count);
        return count;
    }

    private boolean bfs(int row, int col, int rowCount, int colCount, int[][] grid, boolean[][] visited) {

        visited[row][col] = true;
        Queue<int[]> nodeQueue = new LinkedList<>();

        nodeQueue.offer(new int[]{row, col});

        boolean isClosed = true;

        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        while (!nodeQueue.isEmpty()) {
            int[] currNode = nodeQueue.poll();

            int currRow = currNode[0];
            int currCol = currNode[1];


            for (int i = 0; i < 4; i++) {
                int nextRow = currRow + deltaRow[i];
                int nextCol = currCol + deltaCol[i];

                if (!isValid(nextRow, nextCol, rowCount, colCount)) {
                    isClosed = false;
                } else if (isValid(nextRow, nextCol, rowCount, colCount) &&
                        grid[nextRow][nextCol] == 0 &&
                        !visited[nextRow][nextCol]) {
                    nodeQueue.offer(new int[]{nextRow, nextCol});
                    visited[nextRow][nextCol] = true;
                }
            }

        }
        return isClosed;
    }

    private boolean isValid(int nextRow, int nextCol, int rowCount, int colCount) {
        return nextRow >= 0 && nextRow < rowCount && nextCol >= 0 && nextCol < colCount;
    }

}
