package com.leetCode.graphs.unionFind;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Here do BFS from each node in grid
 * increment the area if we are good to connect components
 * maximum connected component will the answer
 */
public class MaxAreaOfIslands {
    public int maxAreaOfIsland(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        boolean[][] visited = new boolean[rowCount][colCount];
        int maxArea = 0;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int currArea = bfs(i, j, rowCount, colCount, grid, visited);
                    maxArea = Math.max(maxArea, currArea);
                }
            }
        }
        System.out.print(maxArea);
        return maxArea;
    }

    private int bfs(int row, int col, int rowCount, int colCount, int[][] grid, boolean[][] visited) {

        Queue<int[]> nodeQueue = new LinkedList<>();
        nodeQueue.offer(new int[]{row, col});
        int area = 0;

        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        while (!nodeQueue.isEmpty()) {
            int[] currNode = nodeQueue.poll();

            row = currNode[0];
            col = currNode[1];

            if (visited[row][col]) {
                continue;
            }

            visited[row][col] = true;
            area++;

            for (int i = 0; i < 4; i++) {
                int nextRow = row + deltaRow[i];
                int nextCol = col + deltaCol[i];

                if (isValid(nextRow, nextCol, rowCount, colCount) &&
                        grid[nextRow][nextCol] == 1 &&
                        !visited[nextRow][nextCol]) {
                    nodeQueue.offer(new int[]{nextRow, nextCol});
                }
            }

        }
        return area;
    }

    private boolean isValid(int nextRow, int nextCol, int rowCount, int colCount) {
        return nextRow >= 0 && nextRow < rowCount && nextCol >= 0 && nextCol < colCount;
    }
}
