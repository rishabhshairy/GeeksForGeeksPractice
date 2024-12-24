package com.leetCode.graphs;

import java.util.PriorityQueue;

public class MinTimeToVisitCell {
    /**
     * Approach
     * using modified Dijkstra's to solve this problem
     * if we are not able to move to next neighbor cell
     * we will return -1
     * <p>
     * Considering Cells as graph nodes
     *
     * @param grid
     * @return
     */
    public int minimumTime(int[][] grid) {
        if (grid[0][1] != 1 && grid[1][0] != 1) {
            return -1;
        }

        int rowCount = grid.length;
        int colCount = grid[0].length;

        int[][] visited = new int[rowCount][colCount];

        PriorityQueue<Vertex> vertexPriorityQueue = new PriorityQueue<>((x, y) -> x.time - y.time);
        vertexPriorityQueue.offer(new Vertex(0, 0, grid[0][0]));

        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        while (!vertexPriorityQueue.isEmpty()) {
            Vertex currVertex = vertexPriorityQueue.poll();

            int currRow = currVertex.row;
            int currCol = currVertex.col;
            int currTime = currVertex.time;

            if (currRow == rowCount - 1 && currCol == colCount - 1) {
                return currTime;
            }
            if (visited[currRow][currCol] == 1) {
                continue;
            }
            visited[currRow][currCol] = 1;

            for (int i = 0; i < 4; i++) {
                int nextRow = currRow + deltaRow[i];
                int nextCol = currCol + deltaCol[i];

                if (nextRow >= 0 && nextCol >= 0 && nextRow < rowCount && nextCol < colCount && visited[nextRow][nextCol]==0) {
                    // maximising the time if we are not able to reach to target with current time + 1
                    int wait = (grid[nextRow][nextCol] - currTime) % 2 == 0 ? 1 : 0;
                    vertexPriorityQueue.offer(new Vertex(nextRow, nextCol, Math.max(grid[nextRow][nextCol] + wait, currTime + 1)));
                }
            }
        }
        return -1;
    }

    static class Vertex {
        int row, col, time;

        public Vertex(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
}
