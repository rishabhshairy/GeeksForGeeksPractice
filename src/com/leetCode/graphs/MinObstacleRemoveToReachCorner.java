package com.leetCode.graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * LC 2290
 */
public class MinObstacleRemoveToReachCorner {
    /**
     * Approach
     * <p>
     * use Dijkstra Algorithm
     * node with grid value 0 --> edge weight 0
     * node with grid value 1 --> edge weight 1
     * <p>
     * this can be inferred as Shortest path problem
     *
     * @param grid
     * @return
     */
    public int minimumObstacles(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;

        int[][] minObstacles = new int[rowCount][colCount];

        for (int i = 0; i < minObstacles.length; i++) {
            Arrays.fill(minObstacles[i], (int) 1e9);
        }
        minObstacles[0][0] = 0;

        PriorityQueue<Vertex> nodeQueue = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        nodeQueue.offer(new Vertex(0, 0, 0));

        // declare directions array
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        while (!nodeQueue.isEmpty()) {
            Vertex currVertex = nodeQueue.poll();

            int currRow = currVertex.row;
            int currCol = currVertex.col;
            int obstacle = currVertex.weight;

            if (currRow == rowCount - 1 && currCol == colCount - 1) {
                return obstacle;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = currRow + deltaRow[i];
                int nextCol = currCol + deltaCol[i];

                if (nextRow >= 0 && nextCol >= 0 && nextRow < rowCount && nextCol < colCount) {
                    int nextObstacle = obstacle + grid[nextRow][nextCol];

                    if (nextObstacle < minObstacles[nextRow][nextCol]) {
                        minObstacles[nextRow][nextCol] = nextObstacle;
                        nodeQueue.offer(new Vertex(nextRow, nextCol, nextObstacle));
                    }
                }
            }
        }
        return minObstacles[rowCount - 1][colCount - 1];
    }

    static class Vertex {
        int row, col, weight;

        public Vertex(int row, int col, int weight) {
            this.row = row;
            this.col = col;
            this.weight = weight;
        }
    }
}
