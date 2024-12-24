package com.graphs.minSpanningTree;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SwimInRisingWater {
    static class Node {
        int row, col, distanceDiff;

        public Node(int row, int col, int distanceDiff) {
            this.row = row;
            this.col = col;
            this.distanceDiff = distanceDiff;
        }
    }

    public int swimInWater(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;

        boolean[][] visited = new boolean[rowCount][colCount];

        for (boolean[] row : visited) {
            Arrays.fill(row, false);
        }

        PriorityQueue<Node> nodeQueue = new PriorityQueue<>((x, y) -> x.distanceDiff - y.distanceDiff);
        nodeQueue.offer(new Node(0, 0, grid[0][0]));
        visited[0][0] = true;


        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        while (!nodeQueue.isEmpty()) {
            Node currNode = nodeQueue.poll();

            int currRow = currNode.row;
            int currCol = currNode.col;
            int currDistance = currNode.distanceDiff;

            if (currRow == rowCount - 1 && currCol == colCount - 1) {
                return currDistance;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = deltaRow[i] + currRow;
                int nextCol = deltaCol[i] + currCol;
                if (isValid(nextRow, nextCol, rowCount, colCount) && !visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    int diff = Math.max(grid[nextRow][nextCol], currDistance);
                    nodeQueue.offer(new Node(nextRow, nextCol, diff));
                }
            }
        }
        return 0;
    }

    private boolean isValid(int nextRow, int nextCol, int rowCount, int colCount) {
        return nextRow >= 0 && nextRow < rowCount && nextCol >= 0 && nextCol < colCount;
    }
}
