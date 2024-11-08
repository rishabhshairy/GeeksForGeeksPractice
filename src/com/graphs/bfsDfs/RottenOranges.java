package com.graphs.bfsDfs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    static class Orange {
        int row;
        int col;
        int time;

        public Orange(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    /**
     * BFS approach, as we need to rot oranges in simultaneous manner
     *
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        Queue<Orange> orangeQueue = new LinkedList<>();
        int rowSize = grid.length;
        int colSize = grid[0].length;

        // making a copy se we don't hamper the input
        int[][] visited = new int[rowSize][colSize];
        int freshOranges = 0;


        // find the rotten pair and add in queue
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (grid[i][j] == 2) {
                    orangeQueue.offer(new Orange(i, j, 0));
                    visited[i][j] = 2;
                } else if (grid[i][j] == 0) {
                    visited[i][j] = 0;
                } else if (grid[i][j] == 1) {
                    visited[i][j] = 1;
                    freshOranges++;
                }
            }
        }

        int maxTime = 0;
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};
        int rottenCount = 0;
        // now do BFS
        while (!orangeQueue.isEmpty()) {
            int currRow = orangeQueue.peek().row;
            int currCol = orangeQueue.peek().col;
            int currTime = orangeQueue.peek().time;
            maxTime = Math.max(maxTime, currTime);
            orangeQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = currRow + deltaRow[i];
                int nextCol = currCol + deltaCol[i];

                if (nextRow >= 0 && nextRow < rowSize && nextCol >= 0 && nextCol < colSize &&
                        visited[nextRow][nextCol] == 1) {
                    orangeQueue.add(new Orange(nextRow, nextCol, currTime + 1));
                    visited[nextRow][nextCol] = 2;
                    rottenCount++;
                }
            }
        }

        if (rottenCount != freshOranges) {
            return -1;
        }
        return maxTime;
    }
}
